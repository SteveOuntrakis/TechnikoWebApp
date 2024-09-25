package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.exception.RepositoryException;
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
    public Admin findAdminByUsername(String username) {
        try {
            List<Admin> admins = repository.findAllByUsername(username);
            return admins.isEmpty() ? null : admins.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean validateAdminsPassword(String password, Admin admin) {
        return password.equals(admin.getPassword());
    }

    @Override
    public Admin getById(Long id, Class<Admin> admin) {
        try {
            return repository.findById(id, admin);
        } catch (RepositoryException e) {
            throw new RepositoryException(e.getMessage());
        }

    }

    @Override
    public List<Admin> getAll(Class<Admin> admin) {
        try {
            return repository.findAll(admin);
        } catch (RepositoryException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Admin save(Admin admin) {
        try {
            return repository.save(admin);
        } catch (RepositoryException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(Long id, Class<Admin> admin) {
        return repository.deleteById(id, admin);
    }

    @Override
    public boolean undeleteById(Long id, Class<Admin> admin) {
        return repository.undeletePostById(id, admin);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Admin> findAllByPropertyId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
