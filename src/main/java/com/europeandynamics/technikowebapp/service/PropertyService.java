package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.Property;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Optional;

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
    public List<Property> getAll(Class<Property> entityClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteById(Long id, Class<Property> entityClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Property getById(Long id, Class<Property> entityClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Property> save(Property t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
