package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.PropertyOwner;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestScoped
@Named("PropertyOwnerRepo")
public class PropertyOwnerRepository extends RepositoryImpl<PropertyOwner, Long> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

}
