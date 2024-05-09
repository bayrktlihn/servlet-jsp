package io.bayrktlihn.bookstorewebsite.repository.impl;

import io.bayrktlihn.bookstorewebsite.context.EntityManagerContextHolder;
import io.bayrktlihn.bookstorewebsite.entity.Category;
import io.bayrktlihn.bookstorewebsite.repository.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public List<Category> findAll() {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Category> query = entityManager.createQuery("select c from Category c", Category.class);
        return query.getResultList();
    }

    @Override
    public Category findById(Long id) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        return entityManager.find(Category.class, id);
    }

    @Override
    public Category save(Category entity) {
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
    public void delete(Category entity) {
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
        Category category = findById(id);
        category = entityManager.merge(category);
        entityManager.remove(category);
        transaction.commit();
    }

    @Override
    public long count() {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select count(c) from Category c", Long.class);
        return query.getSingleResult();
    }

    @Override
    public Category findByName(String name) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Category> query = entityManager.createQuery("select c from Category c where c.name = :name", Category.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public boolean existsByName(String name) {
        EntityManager entityManager = EntityManagerContextHolder.getEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select count(c) from Category c where c.name = :name", Long.class);
        query.setParameter("name", name);
        return query.getSingleResult() > 0;
    }
}
