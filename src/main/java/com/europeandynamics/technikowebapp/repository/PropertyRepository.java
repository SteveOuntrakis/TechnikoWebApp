package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.Property;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("PropertyRepo")
public class PropertyRepository extends RepositoryImpl<Property, Long> {

}
