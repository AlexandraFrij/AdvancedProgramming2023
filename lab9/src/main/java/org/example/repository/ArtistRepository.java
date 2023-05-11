package org.example.repository;

import org.example.EntityManagerFactorySingleton;
import org.example.entity.Artist;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
/**
 * describes operations on table Artist
 */
public class ArtistRepository extends DataRepository<Artist, Integer> {
    private EntityManager em;

    public ArtistRepository() {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        em = emf.createEntityManager();
    }

    /**
     * @param name artist's name
     * @return Artist with the given name
     */
    public Artist findId(String name) {
        return (Artist) em.createNamedQuery("Artist.findID").setParameter("name", name).getSingleResult();
    }

    /**
     * @param id an artist's id
     * @return list of artists with the given id
     */
    public List<Artist> findById(int id) {
        return em.createNamedQuery("Artist.findById")
                .setParameter("id", id)
                .getResultList();
    }

    /**
     * @param name an artist's name
     * @return a list of artists with the given name
     */
    public List<Artist> findByName(String name) {
        return em.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    /**
     * adds a new instance in table Artist
     *
     * @param artist the instance to be added
     */
    public void create(Artist artist) {
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
    }
}
