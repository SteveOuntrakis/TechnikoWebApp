package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.Admin;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
@Named("AdminRepo")
public class AdminRepository extends RepositoryImpl<Admin, Long> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Transactional
    public List<Admin> findAllByUsername(String username) {
        TypedQuery<Admin> query
                = entityManager.createQuery("from " + Admin.class.getName()
                        + " where username  like :username ",
                        Admin.class)
                        .setParameter("username", username);
        return query.getResultList();
    }
}
