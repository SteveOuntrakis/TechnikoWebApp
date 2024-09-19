package com.europeandynamics.technikowebapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T, K> implements Repository<T, K> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Override
    public Optional<T> findById(K id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public List<T> findAll(Class<T> entityClass) {
        TypedQuery<T> query = entityManager.createQuery("from " + entityClass.getName(), entityClass);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Optional<T> save(T t) {
        entityManager.persist(t);
        return Optional.of(t);
    }

    @Override
    public boolean deleteById(K id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
