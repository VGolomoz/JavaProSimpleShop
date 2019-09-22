package simpleshop.service;

import simpleshop.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO {

    private static final String UNIT_NAME = "SimpleShop";
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
    private static EntityManager em = emFactory.createEntityManager();

    public void create(){

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            User client = new User("client", "client", "client");
            em.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }
    }

    public void delete(Object object){

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }
    }
}
