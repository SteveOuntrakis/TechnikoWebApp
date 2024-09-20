package com.europeandynamics.technikowebapp.service;

import java.util.List;

/**
 *
 * @param <T>
 * @param <K>
 */
public interface Service<T, K> {

    T getById(K id, Class<T> entityClass);

    List<T> getAll(Class<T> entityClass);

    T save(T t);

    boolean deleteById(K id, Class<T> entityClass);
    
    T findOwnerByUsername(String username);

}
