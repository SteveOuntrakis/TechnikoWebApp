package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.Admin;
import com.europeandynamics.technikowebapp.model.enums.Status;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestScoped
public class AdminService implements Service<Admin, Long> {

    @Inject
    @Named("AdminRepo")
    private Repository<Admin, Long> repository;

    @Override
    public Admin getById(Long id, Class<Admin> admin) {
        return repository.findById(id, admin);
    }

    @Override
    public List<Admin> getAll(Class<Admin> admin) {
        return repository.findAll(admin);
    }

    @Override
    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public boolean deleteById(Long id, Class<Admin> admin) {
        return repository.deleteById(id, admin);
    }

    @Override
    public Admin findOwnerByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Admin> findPendingRepairsForID(Status status, Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Admin> findPropertiesByUserID(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public List<Admin> findPendingRepairs(Status status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Admin> findAllByPropertyId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
