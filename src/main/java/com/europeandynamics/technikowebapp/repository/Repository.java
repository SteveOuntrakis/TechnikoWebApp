package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.BaseModel;
import com.europeandynamics.technikowebapp.model.enums.Status;
import java.util.Date;
import java.util.List;

public interface Repository<T, K> {

    T findById(K id, Class<T> entityClass);

    List<T> findAll(Class<T> entityClass);

    <T extends BaseModel> T save(T t);

    boolean deleteById(K id, Class<T> entityClass);
    
    boolean undeletePostById(K id , Class<T> entityClass);

    List<T> findAllByUsername(String username);

    List<T> findByUserId(K userId);

    List<T> findByDateRange(Date startDate, Date endDate);

    List<T> findPendingRepairs(Status status);

    List<T> findAllByPropertyId(K propertyId);

    List<T> findPropertiesByUserID(K userId);

    List<T> findPendingRepairsForID(Status status, K id);
}
