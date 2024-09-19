package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.PropertyRepair;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestScoped
@Named("PropertyRepairRepo")
public class PropertyRepairRepository extends RepositoryImpl<PropertyRepair, Long> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

   
}
