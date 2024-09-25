package com.europeandynamics.technikowebapp.resources;

import com.europeandynamics.technikowebapp.model.Admin;
import com.europeandynamics.technikowebapp.model.PropertyOwner;
import com.europeandynamics.technikowebapp.model.UserCredentials;
import com.europeandynamics.technikowebapp.service.AdminService;
import com.europeandynamics.technikowebapp.service.PropertyOwnerService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author stef6
 * Example how the login page could be 
 */
@Path("/login")
public class LoginWeb {

    @Inject
    private AdminService adminService;

    @Inject
    private PropertyOwnerService propertyOwnerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserCredentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        Admin admin = adminService.findAdminByUsername(username);
        if (admin != null && adminService.validateAdminsPassword(password, admin)) {
            return Response.ok("Admin Home Page").build();  
        }

        PropertyOwner propertyOwner = propertyOwnerService.findOwnerByUsername(username);
        if (propertyOwner != null && propertyOwnerService.validatePropertyOwnerPassword(password, propertyOwner)) {
            return Response.ok("Property Owner Home Page").build();  
        }

        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
    }
}
