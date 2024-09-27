package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.enums.Status;
import java.util.List;

/**
 *
 * @param <T>
 * @param <K>
 */
public interface Service<T, K> {

    T getById(K id, Class<T> entityClass);

    List<T> getAll(Class<T> entityClass);

    T save(T t,K id);
    
    boolean deleteById(K id, Class<T> entityClass);
    
    boolean undeleteById(K id, Class<T> entityClass);

    T findOwnerByUsername(String username);

    List<T> findPendingRepairsForID(Status status, K id);

    List<T> findPropertiesByUserID(K id);

    List<T> findPendingRepairs(Status status);

    List<T> findAllByPropertyId(K id);

    T findAdminByUsername(String username);

    boolean validateAdminsPassword(String password, T t);
}
