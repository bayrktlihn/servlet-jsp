package io.bayrktlihn.bookstorewebsite.repository.impl;

import io.bayrktlihn.bookstorewebsite.config.JpaConfig;
import io.bayrktlihn.bookstorewebsite.context.EntityManagerContextHolder;
import io.bayrktlihn.bookstorewebsite.entity.Category;
import io.bayrktlihn.bookstorewebsite.entity.User;
import io.bayrktlihn.bookstorewebsite.repository.CategoryRepository;
import io.bayrktlihn.bookstorewebsite.repository.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryImplTest {

    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @BeforeAll
    void beforeAll() {
        EntityManagerContextHolder.setEntityManager(JpaConfig.getNewEntityManager());

        userRepository = new UserRepositoryImpl();
        categoryRepository = new CategoryRepositoryImpl();

        userRepository.save(User.create("name@code.java.net", "mysecret", "Nam Ha Minh"));
        userRepository.save(User.create("sophia@robotics.com", "robotic", "Miss Sophia"));
        userRepository.save(User.create("you@gmail.com", "power", "Mr President"));
        userRepository.save(User.create("david@gmail.com", "1234567890", "David Beckham"));


        categoryRepository.save(Category.create("Java"));
    }

    @AfterAll
    void afterAll(){
        EntityManagerContextHolder.clearContext();
    }

    @Test
    void findByEmail(){
        User user = userRepository.findByEmail("name@code.java.net");

        Assertions.assertNotNull(user);
    }


    @Test
    void countUsers() {
        long count = userRepository.count();

        Assertions.assertEquals(4, count);
    }

    @Test
    void deleteById() {
        userRepository.deleteById(1L);

        Assertions.assertEquals(3, userRepository.count());
    }

}