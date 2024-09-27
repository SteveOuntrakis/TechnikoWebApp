package com.europeandynamics.technikowebapp.resources;

import com.europeandynamics.technikowebapp.model.PropertyRepair;
import com.europeandynamics.technikowebapp.model.enums.Status;
import com.europeandynamics.technikowebapp.service.Service;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Path("propertyRepair")
@Slf4j
public class PropertyRepairWeb {

    @Inject
    private Service<PropertyRepair, Long> eshopService;

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PropertyRepair> getAll() {
        return eshopService.getAll(PropertyRepair.class);
    }

    @Path("/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyRepair getById(@PathParam("id") Long id) {
        return eshopService.getById(id, PropertyRepair.class);
    }
    
    @Path("/pending")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PropertyRepair> findPendingRepairs() {
        return eshopService.findPendingRepairs(Status.PENDING);
    }
    @Path("/property/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PropertyRepair> findAllByPropertyId(@PathParam("id") Long id) {
        return eshopService.findAllByPropertyId(id);
    }
    @Path("/pending/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PropertyRepair> findPendingRepairsForID(@PathParam("id") Long id) {
        return eshopService.findPendingRepairsForID(Status.PENDING, id);
    }

    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyRepair save(PropertyRepair propertyRepair) {
        return eshopService.save(propertyRepair,null);
    }
    
    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyRepair update(@Valid PropertyRepair propertyRepair,@PathParam("id") long id) {
        return eshopService.save(propertyRepair,id);
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteById(@PathParam("id") long id) {
        return eshopService.deleteById(id, PropertyRepair.class);
    }
}
