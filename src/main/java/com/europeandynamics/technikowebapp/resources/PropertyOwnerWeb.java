package com.europeandynamics.technikowebapp.resources;

import com.europeandynamics.technikowebapp.model.PropertyOwner;
import com.europeandynamics.technikowebapp.service.Service;
import jakarta.inject.Inject;
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

@Path("")
@Slf4j
public class PropertyOwnerWeb {

    @Inject
    private Service<PropertyOwner, Long> eshopService;

    @Path("propertyOwner")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PropertyOwner> getAll() {
        return eshopService.getAll(PropertyOwner.class);
    }

    @Path("propertyOwner/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyOwner getById(@PathParam("id") Long id) {
        return eshopService.getById(id, PropertyOwner.class);
    }
    
    @Path("propertyOwner/{name}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyOwner findOwnerByUsername(@PathParam("name") String username) {
        return eshopService.findOwnerByUsername(username);
    }

    @Path("propertyOwner")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyOwner save(PropertyOwner propertyOwner) {
        return eshopService.save(propertyOwner);
    }

    @Path("propertyOwner/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteById(@PathParam("id") long id) {
        return eshopService.deleteById(id, PropertyOwner.class);
    }
}
