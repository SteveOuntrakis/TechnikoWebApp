package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.Property;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

public class PropertyService implements Service<Property, Long> {

    @Inject
    @Named("PropertyRepo")
    private Repository<Property, Long> repository;


//    public List<Property> findPropertiesByUserID(Long id) {
//        try {
//            List<Property> properties = repository.findPropertiesByUserID(id);
//            return properties;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public List<Property> findPendingRepairsForID(Status status, Long id) {
//        try {
//            List<Property> properties = repository.findPendingRepairsForID(status, id);
//            return properties;
//        } catch (Exception e) {
//            return null;
//        }
//    }

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

}
