package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.PropertyRepair;
import com.europeandynamics.technikowebapp.model.enums.Status;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestScoped
public class PropertyRepairService implements Service<PropertyRepair, Long> {

    @Inject
    @Named("PropertyRepairRepo")
    private Repository<PropertyRepair, Long> repository;
    
    public List<PropertyRepair> findPendingRepairs(Status status) {
     
            List<PropertyRepair> repairs = repository.findPendingRepairs(status);
            return repairs;
    }

    public List<PropertyRepair> findAllByPropertyId(Long id) {
       
            List<PropertyRepair> repairs = repository.findAllByPropertyId(id);
            return repairs;
    }

    public List<PropertyRepair> findPendingRepairsForID(Status status, Long id) {
            List<PropertyRepair> repairs = repository.findPendingRepairsForID(status, id);
            return repairs;
    }

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

    @Override
    public List<PropertyRepair> findPropertiesByUserID(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
