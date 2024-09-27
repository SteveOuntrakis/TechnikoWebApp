package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.Property;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
@Named("PropertyRepo")
public class PropertyRepository extends RepositoryImpl<Property, Long> {
    
    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;
   
    @Transactional
    public List<Property> findPropertiesByUserID(Long userId) {
        TypedQuery<Property> query
                = entityManager.createQuery("from " + Property.class.getName()
                        + " where owner.id = :user_id ",
                        Property.class)
                        .setParameter("user_id", userId);
        return query.getResultList();
    }
}
