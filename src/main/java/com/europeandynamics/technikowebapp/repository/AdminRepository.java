package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.Admin;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("AdminRepo")
public class AdminRepository extends RepositoryImpl<Admin, Long> {

}
