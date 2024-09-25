package com.europeandynamics.technikowebapp.security;

import com.europeandynamics.technikowebapp.model.Admin;
import com.europeandynamics.technikowebapp.model.PropertyOwner;
import com.europeandynamics.technikowebapp.service.AdminService;
import com.europeandynamics.technikowebapp.service.PropertyOwnerService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestFilter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

@Provider
public class TechnikoAuthenticationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Inject
    private AdminService adminService;

    @Inject
    private PropertyOwnerService propertyOwnerService;

    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";

    @Override
    public void filter(ContainerRequestContext requestContext) {

        Method method = resourceInfo.getResourceMethod();

        if (method.isAnnotationPresent(PermitAll.class) || !method.isAnnotationPresent(RolesAllowed.class)) {
            return;
        }

        final MultivaluedMap<String, String> headers = requestContext.getHeaders();
        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

        if (authorization == null || authorization.isEmpty()) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("You cannot access this resource").build());
            return;
        }

        final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
        String usernameAndPassword = new String(Base64.getDecoder().decode(encodedUserPassword.getBytes()));

      
        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        
        if (!validateUser(username, password)) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid credentials").build());
            return;
        }

        String userRole = getUserRole(username);
        RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
        Set<String> rolesSetForTheResource = new HashSet<>(Arrays.asList(rolesAnnotation.value()));

        if (!rolesSetForTheResource.contains(userRole)) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Insufficient permissions").build());
            return;
        }
    }

    private boolean validateUser(String username, String password) {
        Admin admin = adminService.findAdminByUsername(username);
        if (admin != null && adminService.validateAdminsPassword(password, admin)) {
            return true;
        }

        PropertyOwner propertyOwner = propertyOwnerService.findOwnerByUsername(username);
        if (propertyOwner != null && propertyOwnerService.validatePropertyOwnerPassword(password, propertyOwner)) {
            return true;
        }

        return false; 
    }

    private String getUserRole(String username) {
        Admin admin = adminService.findAdminByUsername(username);
        if (admin != null) {
            return "ADMIN";
        }

        PropertyOwner propertyOwner = propertyOwnerService.findOwnerByUsername(username);
        if (propertyOwner != null) {
            return "PROPERTY_OWNER";
        }

        return null; 
    }
}
