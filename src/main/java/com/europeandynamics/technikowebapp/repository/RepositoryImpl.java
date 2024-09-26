package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.exception.DatabaseOperationException;
import com.europeandynamics.technikowebapp.model.BaseModel;
import com.europeandynamics.technikowebapp.model.enums.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RepositoryImpl<T extends BaseModel, K> implements Repository<T, K> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Override
    @Transactional
    public T findById(K id, Class<T> entityClass) {
        try {
            T t = entityManager.find(entityClass, id);
            if (t != null && !t.isDeleted()) {
                return t;
            }
            return null;
        } catch (Exception e) {
            log.debug("An exception occured");
            return null;
        }
    }

    @Override
    @Transactional
    public List<T> findAll(Class<T> t) {
        try {
            TypedQuery<T> query = entityManager.createQuery("from " + t.getName(), t);
            List<T> list = query.getResultList();
            List<T> newList = new ArrayList<>();
            for (T value : list) {
                if (value != null && !value.isDeleted()) {
                    newList.add(value);
                }
            }

            return newList;
        } catch (Exception e) {
            throw new DatabaseOperationException("save", t.getClass().toString(), e);
        }

    }

    @Override
    @Transactional
    public <T extends BaseModel> T save(T t) {
        try {
            if (t.getId() == null) {
                entityManager.persist(t);
            } else {
                t = entityManager.merge(t);
            }
            return t;
        } catch (Exception e) {
            throw new DatabaseOperationException("save", t.getClass().toString(), e);
        }

    }

    @Override
    @Transactional
    public boolean deleteById(K id, Class<T> entityClass) {
        return setDeletedPostById(id, entityClass, true);
    }

    @Override
    @Transactional
    public boolean undeletePostById(K id, Class<T> entityClass) {
        return setDeletedPostById(id, entityClass, false);
    }

    private boolean setDeletedPostById(K id, Class<T> entityClass, boolean deleted) {

        T persistentInstance = entityManager.find(entityClass, id);
        if (persistentInstance != null) {
            log.info("all ok");
            persistentInstance.setDeleted(deleted);
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
