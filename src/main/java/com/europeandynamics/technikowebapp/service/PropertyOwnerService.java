package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.PropertyOwner;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

public class PropertyOwnerService implements Service<PropertyOwner, Long> {

    @Inject
    @Named("PropertyOwnerRepo")
    private Repository<PropertyOwner, Long> repository;
  

    public PropertyOwner findOwnerByUsername(String username) {
        try {
            List<PropertyOwner> owners = repository.findAllByUsername(username);
            return owners.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validatePropertyOwnerPassword(String password, PropertyOwner owner) {
        return password.equals(owner.getPassword());
    }

    @Override
    public PropertyOwner getById(Long id,Class<PropertyOwner> propertyOwner) {
        return repository.findById(id,propertyOwner);
    }

    @Override
    public List<PropertyOwner> getAll(Class<PropertyOwner> propertyOwner) {
        return repository.findAll(propertyOwner);
    }

    @Override
    public PropertyOwner save(PropertyOwner propertyOwner) {
        return repository.save(propertyOwner);
    }

    @Override
    public boolean deleteById(Long id,Class<PropertyOwner> propertyOwner) {
        return repository.deleteById(id,propertyOwner);
    }
}
