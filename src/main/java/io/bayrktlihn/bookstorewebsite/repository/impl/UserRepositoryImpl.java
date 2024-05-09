package io.bayrktlihn.bookstorewebsite.repository.impl;

import io.bayrktlihn.bookstorewebsite.context.EntityManagerContextHolder;
import io.bayrktlihn.bookstorewebsite.entity.User;
import io.bayrktlihn.bookstorewebsite.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> findAll() {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        return entityManager.find(User.class, id);
    }

    @Override
    public User save(User entity) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        if (entity.getId() != null) {
            entity = entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
        }
        transaction.commit();
        return entity;
    }

    @Override
    public void delete(User entity) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = findById(id);
        user = entityManager.merge(user);
        entityManager.remove(user);
        transaction.commit();
    }

    @Override
    public long count() {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select count(u) from User u", Long.class);
        return query.getSingleResult();
    }

    @Override
    public User findByEmail(String email) {

        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();

        TypedQuery<User> userQuery = entityManager.createQuery("select u from User u where u.email = :email", User.class);
        userQuery.setParameter("email", email);

        return userQuery.getSingleResult();
    }

    @Override
    public boolean existsByEmail(String email) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select count(u) from User u where u.email = :email", Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }

    @Override
    public boolean existsById(Long id) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select count(u) from User u where u.id = :id", Long.class);
        query.setParameter("id", id);
        return query.getSingleResult() > 0;
    }

    @Override
    public boolean checkPassword(String email, String password) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select count(u) from User u where u.email = :email and u.password = :password", Long.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getSingleResult() == 1;
    }
}
