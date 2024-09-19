package com.europeandynamics.technikowebapp.resources;

import com.europeandynamics.technikowebapp.model.Admin;
import com.europeandynamics.technikowebapp.service.Service;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Path("")
@Slf4j
public class AdminWeb {

    @Inject
    private Service<Admin,Long> eshopService;

    @Path("home")
    @GET
    public String home() {
        return "hello to our eshop";
    }

    @Path("admin")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Admin> getAll() {
        return eshopService.getAll(Admin.class);
    }
    
    @Path("admin/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Optional<Admin> getById(@PathParam ("id")Long id){
        return eshopService.getById(id);
    }
    
    @Path("admin")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Admin> save(Admin admin){
        return eshopService.save(admin);        
    }
//
//    boolean deleteById(K id);
}