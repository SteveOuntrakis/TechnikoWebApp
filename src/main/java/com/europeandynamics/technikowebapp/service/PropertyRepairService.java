package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.PropertyRepair;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Optional;

public class PropertyRepairService implements Service<PropertyRepair, Long> {

    @Inject
    @Named("PropertyRepairRepo")
    private Repository<PropertyRepair, Long> repository;




//    public List<PropertyRepair> findPendingRepairs(Status status) {
//        try {
//            List<PropertyRepair> owners = repository.findPendingRepairs(status);
//            return owners;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public List<PropertyRepair> findAllByPropertyId(Long id) {
//        try {
//            List<PropertyRepair> owners = repository.findAllByPropertyId(id);
//            return owners;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public List<PropertyRepair> findPendingRepairsForID(Status status, Long id) {
//        try {
//            List<PropertyRepair> owners = repository.findPendingRepairsForID(status, id);
//            return owners;
//        } catch (Exception e) {
//            return null;
//        }
//
//    }

    @Override
    public PropertyRepair getById(Long id,Class<PropertyRepair> propertyRepair) {
        return repository.findById(id,propertyRepair);
    }

    @Override
    public List<PropertyRepair> getAll(Class<PropertyRepair> propertyRepair) {
        return repository.findAll(propertyRepair);
    }

    @Override
    public PropertyRepair save(PropertyRepair propertyRepair) {
        return repository.save(propertyRepair);
    }

    @Override
    public boolean deleteById(Long id,Class<PropertyRepair> propertyRepair) {
        return repository.deleteById(id,propertyRepair);
    }

    @Override
    public PropertyRepair findOwnerByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
