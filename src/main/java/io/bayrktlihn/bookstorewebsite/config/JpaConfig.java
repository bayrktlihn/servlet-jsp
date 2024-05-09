package io.bayrktlihn.bookstorewebsite.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConfig {


    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("bookStoreWebsite");
    }

    public static EntityManager getNewEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

}
