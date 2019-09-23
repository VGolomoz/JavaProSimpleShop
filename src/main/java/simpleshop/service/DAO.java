package simpleshop.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO {

    private static final String UNIT_NAME = "SimpleShop";
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
    private static EntityManager em = emFactory.createEntityManager();
    EntityTransaction transaction;

    public void create(Object ... objects){
        transaction = em.getTransaction();
        transaction.begin();
        try {
            for (Object o:objects) {
                em.persist(o);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }
    }

    public void update(Object ... objects){
        transaction = em.getTransaction();
        transaction.begin();
        try {
            for (Object o:objects) {
                em.persist(o);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }
    }

    public void delete(Object...objects){
        transaction = em.getTransaction();
        transaction.begin();
        try {
            for (Object o:objects) {
                em.persist(o);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }
    }
}
