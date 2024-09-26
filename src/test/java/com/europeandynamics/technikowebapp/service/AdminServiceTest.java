package com.europeandynamics.technikowebapp.service;

import com.europeandynamics.technikowebapp.model.Admin;
import com.europeandynamics.technikowebapp.repository.AdminRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author stef6
 * a dummy Test class 
 */
public class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private AdminRepository adminRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAdminById_Success() {
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setUsername("admin");
        when(adminRepository.findById(1L,Admin.class)).thenReturn(admin);
        Admin result = adminService.getById(1L, Admin.class);
        assertNotNull(result);
        assertEquals("admin", result.getUsername());
        verify(adminRepository, times(1)).findById(1L,Admin.class);
    }

}
