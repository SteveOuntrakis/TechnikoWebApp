package com.europeandynamics.technikowebapp.repository;

import com.europeandynamics.technikowebapp.model.PropertyRepair;
import com.europeandynamics.technikowebapp.model.enums.Status;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
@Named("PropertyRepairRepo")
public class PropertyRepairRepository extends RepositoryImpl<PropertyRepair, Long> {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

    @Transactional
    public List<PropertyRepair> findPendingRepairs(Status status) {
        TypedQuery<PropertyRepair> query
                = entityManager.createQuery("from " + PropertyRepair.class.getName()
                        + " where Status = :status ",
                        PropertyRepair.class)
                        .setParameter("status", status);
        return query.getResultList();
    }

    @Transactional
    public List<PropertyRepair> findPendingRepairsForID(Status status, Long property_id) {
        TypedQuery<PropertyRepair> query
                = entityManager.createQuery("from " + PropertyRepair.class.getName()
                        + " pr where pr.Status = :status and pr.property.id = :property_id",
                        PropertyRepair.class)
                        .setParameter("status", status)
                        .setParameter("property_id", property_id);
        return query.getResultList();
    }

    @Transactional
    public List<PropertyRepair> findAllByPropertyId(Long propertyId) {
        TypedQuery<PropertyRepair> query = entityManager.createQuery("from " + PropertyRepair.class.getName()
                + " pr where pr.property.id = :property_id",
                PropertyRepair.class)
                .setParameter("property_id", propertyId);

        return query.getResultList();
    }
}
