package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.PropertyOwner;
import com.europeandynamics.technikowebapp.model.enums.Status;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import jakarta.inject.Named;
import java.util.List;

@Slf4j
@RequestScoped
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
    public PropertyOwner getById(Long id, Class<PropertyOwner> propertyOwner) {
        return repository.findById(id, propertyOwner);
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
    public boolean deleteById(Long id, Class<PropertyOwner> propertyOwner) {
        return repository.deleteById(id, propertyOwner);
    }
    
    @Override
    public boolean undeleteById(Long id, Class<PropertyOwner> propertyOwner) {
        return repository.undeletePostById(id,propertyOwner);
    }

    @Override
    public List<PropertyOwner> findPendingRepairsForID(Status status, Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PropertyOwner> findPropertiesByUserID(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PropertyOwner> findPendingRepairs(Status status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PropertyOwner> findAllByPropertyId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PropertyOwner findAdminByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean validateAdminsPassword(String password, PropertyOwner t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
