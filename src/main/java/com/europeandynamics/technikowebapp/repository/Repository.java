package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.BaseModel;
import java.util.List;

public interface Repository<T, K> {

    T findById(K id, Class<T> entityClass);

    List<T> findAll(Class<T> entityClass);

    <T extends BaseModel> T save(T t);

    boolean deleteById(K id, Class<T> entityClass);

    List<T> findAllByUsername(String username);
}
