package org.example.repository;

import org.example.EntityManagerFactorySingleton;
import org.example.entity.Genre;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * describes operations on table Genre
 */
public class GenreRepository extends DataRepository<Genre, Integer> {
    private EntityManager em;

    public GenreRepository() {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        em = emf.createEntityManager();
    }

    /**
     * @param id genre's id
     * @return Genre with the given id
     */
    public List<Genre> findById(int id) {
        return em.createNamedQuery("Genre.findById")
                .setParameter("id", id)
                .getResultList();
    }

    /**
     * @param name genre's name
     * @return Genre with the given name
     */
    public List<Genre> findByName(String name) {
        return em.createNamedQuery("Genre.findById")
                .setParameter("name", name)
                .getResultList();
    }

    /**
     * adds a new instance in table Genre
     *
     * @param genre the instance to be added
     */
    public void create(Genre genre) {
        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
    }
}
