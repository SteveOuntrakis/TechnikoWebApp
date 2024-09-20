package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.PropertyRepair;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("PropertyRepairRepo")
public class PropertyRepairRepository extends RepositoryImpl<PropertyRepair, Long> {

}
