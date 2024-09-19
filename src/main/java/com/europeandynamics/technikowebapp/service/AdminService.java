package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.Admin;
import com.europeandynamics.technikowebapp.repository.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestScoped
public class AdminService implements Service<Admin,Long> {

    @Inject
    @Named("AdminRepo")
    private Repository<Admin,Long> repository;

    @Override
    public Optional<Admin> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Admin> getAll(Class<Admin> admin) {
        return repository.findAll(admin);
    }

    @Override
    public Optional<Admin> save(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
