package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.Property;
import com.europeandynamics.technikowebapp.model.enums.Status;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestScoped
public class PropertyService implements Service<Property, Long> {

    @Inject
    @Named("PropertyRepo")
    private Repository<Property, Long> repository;

    @Override
    public List<Property> findPropertiesByUserID(Long id) {
            List<Property> properties = repository.findPropertiesByUserID(id);
            return properties;    
    }

    @Override
    public Property getById(Long id,Class<Property> property) {
        return repository.findById(id,property);
}

    @Override
    public List<Property> getAll(Class<Property> property) {
        return repository.findAll(property);
    }

    @Override
    public Property save(Property property) {
        return repository.save(property);
    }

    @Override
    public boolean deleteById(Long id,Class<Property> property) {
        return repository.deleteById(id,property);
    }

    @Override
    public Property findOwnerByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Property> findPendingRepairsForID(Status status, Long id) {
       throw new UnsupportedOperationException("Not supported yet.");
    }  

    @Override
    public List<Property> findPendingRepairs(Status status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Property> findAllByPropertyId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
