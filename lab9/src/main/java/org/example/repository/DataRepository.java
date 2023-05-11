package org.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.example.EntityManagerFactorySingleton;

import java.io.Serializable;

import org.dom4j.tree.AbstractEntity;

/**
 * describes operations on all tables
 *
 * @param <T>  generic for table
 * @param <ID> generic for primary key
 */
public abstract class DataRepository<T extends AbstractEntity, ID extends Serializable> {
    private EntityManager em;

    public DataRepository() {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        em = emf.createEntityManager();
    }

    public T findById(ID id) {
        return null;
    }

    public boolean persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
            commit();
            return true;
        } catch (Exception e) {
            handleException(e);
            rollback();
        }
        return false;
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void handleException(Exception e) {
        System.out.println(e);
    }

    public void rollback() {
        em.getTransaction().rollback();
    }
}
