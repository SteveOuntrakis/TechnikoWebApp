package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.Admin;
import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T>
 * @param <K>
 */
public interface Service<T, K> {

    T getById(K id, Class<T> entityClass);

    List<T> getAll(Class<T> entityClass);

    Optional<T> save(T t);

    boolean deleteById(K id, Class<T> entityClass);

}
