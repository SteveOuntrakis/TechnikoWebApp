package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.PropertyOwner;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
@Named("PropertyOwnerRepo")
public class PropertyOwnerRepository extends RepositoryImpl<PropertyOwner, Long> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<PropertyOwner> findAllByUsername(String username) {
        TypedQuery<PropertyOwner> query
                = entityManager.createQuery("from " + PropertyOwner.class.getName()
                        + " where username  like :username ",
                        PropertyOwner.class)
                        .setParameter("username", username);
        return query.getResultList();
    }    
}
