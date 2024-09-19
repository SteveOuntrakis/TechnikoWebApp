package com.europeandynamics.technikowebapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RepositoryImpl<T, K> implements Repository<T, K> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Override
    @Transactional
    public T findById(K id,Class<T> entityClass) {
          try {
            T t = entityManager.find(entityClass, id);
            return t;
        } catch (Exception e) {
            log.debug("An exception occured");
            return null;  
        }   
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
    @Transactional
    public boolean deleteById(K id, Class<T> entityClass) {
        
        T persistentInstance = entityManager.find(entityClass, id);
        if (persistentInstance != null) {
            log.info("all ok");
            entityManager.remove(persistentInstance);
            return true;
        }
        log.info("something happened");
        return false;   
    }
    

}
