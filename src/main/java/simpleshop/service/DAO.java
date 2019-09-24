package simpleshop.service;

import simpleshop.entity.Product;
import simpleshop.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private static DAO instanceDAO = new DAO();

    public static DAO getInstance(){
        return instanceDAO;
    }

    private static final String UNIT_NAME = "SimpleShop";
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
    private static EntityManager em = emFactory.createEntityManager();
    EntityTransaction transaction;

    public void create(Object... objects) {
        transaction = em.getTransaction();
        transaction.begin();
        try {
            for (Object o : objects) {
                em.persist(o);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }
    }

    public User findUserByNameAndPass(String login, String password) {

        User user = null;

        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password", User.class);
            query.setParameter("login", login);
            query.setParameter("password", password);
            user = (User) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("User not found!"); // for log
        }  finally {
            return user;
        }
    }

    public List<Product> findAllProduct(){

        List<Product> products = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT p FROM Product p", Product.class);
            products = query.getResultList();
        } catch (NoResultException ex) {
            System.out.println("Product not found!"); // for log
        }  finally {
            return products;
        }

    }

}
