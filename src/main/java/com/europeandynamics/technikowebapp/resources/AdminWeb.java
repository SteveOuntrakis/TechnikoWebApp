package com.europeandynamics.technikowebapp.resources;

import com.europeandynamics.technikowebapp.model.Admin;
import com.europeandynamics.technikowebapp.service.Service;
import jakarta.annotation.security.RolesAllowed;
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

@Path("admin")
@Slf4j
public class AdminWeb {

    @Inject
    private Service<Admin, Long> eshopService;

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)     
    //@RolesAllowed("ADMIN") <= add this for Basic Auth
    public List<Admin> getAll() {
        return eshopService.getAll(Admin.class);
    }

    @Path("/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Admin getById(@PathParam("id") Long id) {
        return eshopService.getById(id, Admin.class);
    }

    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Admin save(@Valid Admin admin) {
        return eshopService.save(admin);
    }

    @Path("/{adminId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteById(@PathParam("adminId") long adminID) {
        return eshopService.deleteById(adminID, Admin.class);
    }
}
