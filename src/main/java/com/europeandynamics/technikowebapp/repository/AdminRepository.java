package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.Admin;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author stef6
 * @param <T>
 */
@Slf4j
@RequestScoped
@Named("AdminRepo")
public class AdminRepository extends RepositoryImpl<Admin, Long> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    private Class<Admin> getEntityClass() {
        return Admin.class;
    }

    private String getEntityClassName() {
        return Admin.class.getName();
    }
}
