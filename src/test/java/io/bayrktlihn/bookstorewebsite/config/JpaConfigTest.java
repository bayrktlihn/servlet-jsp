package io.bayrktlihn.bookstorewebsite.config;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

class JpaConfigTest {


    @Test
    void getNewEntityManager() {
        EntityManager entityManager = JpaConfig.getNewEntityManager();
    }


}
