package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * singleton class responsible with the management of an EntityManagerFactory object
 */
public class EntityManagerFactorySingleton {
    private static EntityManagerFactory entityManagerFactory = null;

    private EntityManagerFactorySingleton() {
    }

    public static synchronized EntityManagerFactory getInstance() {
        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
        return entityManagerFactory;
    }
}
