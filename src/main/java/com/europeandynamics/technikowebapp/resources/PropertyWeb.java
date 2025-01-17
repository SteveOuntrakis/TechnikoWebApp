package com.europeandynamics.technikowebapp.resources;

import com.europeandynamics.technikowebapp.model.Property;
import com.europeandynamics.technikowebapp.service.Service;
import jakarta.validation.Valid;
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

@Path("property")
@Slf4j
public class PropertyWeb {

    @Inject
    private Service<Property, Long> eshopService;

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Property> getAll() {
        return eshopService.getAll(Property.class);
    }

    @Path("/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Property getById(@PathParam("id") Long id) {
        return eshopService.getById(id, Property.class);
    }
    @Path("/properties/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Property> findPropertiesByUserID(@PathParam("id") Long id) {
        return eshopService.findPropertiesByUserID(id);
    }

    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Property save(Property property) {
        return eshopService.save(property,null);
    }
    
    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Property update(@Valid Property property,@PathParam("id") long id) {
        return eshopService.save(property,id);
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteById(@PathParam("id") Long id) {
        return eshopService.deleteById(id, Property.class);
    }    
}
