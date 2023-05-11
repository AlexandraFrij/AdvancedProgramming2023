package org.example.repository;
import org.example.EntityManagerFactorySingleton;
import org.example.entity.Album;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * describes operations on table Album
 */
public class AlbumRepository extends DataRepository<Album, Integer>{
    private EntityManager em;

    /**
     * constructor method
     */
    public AlbumRepository()
    {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        em = emf.createEntityManager();
    }

    /**
     *
     * @param title an album's title
     * @return a list of albums with the given name
     */
    public List<Album> findByName(String title)
    {
        return em.createNamedQuery("Album.findByTitle")
                .setParameter("title", title)
                .getResultList();
    }

    /**
     *
     * @param id an album's id
     * @return list of albums with the given id
     */
    public List<Album> findById(int id)
    {
        return em.createNamedQuery("Album.findById")
                .setParameter("id", id)
                .getResultList();
    }

    /**
     * adds a new instance in table Album
     *
     * @param album the instance to be added
     */
    public void create(Album album)
    {
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
    }
}
