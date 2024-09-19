package com.europeandynamics.technikowebapp.repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author stef6
 */
public interface Repository<T, K> {

    T findById(K id,Class<T> entityClass);

    List<T> findAll(Class<T> entityClass);

    Optional<T> save(T t);

    boolean deleteById(K id,Class<T> entityClass);
}
