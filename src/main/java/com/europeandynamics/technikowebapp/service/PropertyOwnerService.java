package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.PropertyOwner;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Optional;

public class PropertyOwnerService implements Service<PropertyOwner, Long> {

    @Inject
    @Named("PropertyOwnerRepo")
    private Repository<PropertyOwner, Long> repository;
  

//    public Optional<PropertyOwner> findOwnerByUsername(String username) {
//        try {
//            List<PropertyOwner> owners = repository.findAllByUsername(username);
//            return owners.isEmpty() ? Optional.empty() : Optional.of(owners.get(0));
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }

    public boolean validatePropertyOwnerPassword(String password, PropertyOwner owner) {
        return password.equals(owner.getPassword());
    }

    @Override
    public List<PropertyOwner> getAll(Class<PropertyOwner> entityClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteById(Long id, Class<PropertyOwner> entityClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PropertyOwner getById(Long id, Class<PropertyOwner> entityClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<PropertyOwner> save(PropertyOwner t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
