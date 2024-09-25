package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.BaseModel;
import com.europeandynamics.technikowebapp.model.enums.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RepositoryImpl<T, K> implements Repository<T, K> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Override
    @Transactional
    public T findById(K id, Class<T> entityClass) {
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
    public <T extends BaseModel> T save(T t) {
        if (t.getId() == null) {
            entityManager.persist(t);
        } else {
            t = entityManager.merge(t);
        }
        return t;
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

    @Override
    public List<T> findByUserId(K userId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<T> findByDateRange(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<T> findPendingRepairs(Status status) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<T> findAllByPropertyId(K propertyId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<T> findPropertiesByUserID(K userId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<T> findPendingRepairsForID(Status status, K id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }    

    @Override
    public List<T> findAllByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
