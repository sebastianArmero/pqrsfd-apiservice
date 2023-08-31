package com.smartcampus.security.services;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.smartcampus.models.UsuarioExt;

import java.util.Arrays;
import java.util.List;

public class UserDetailsImplTest {

    @Test
    public void testBuild() {
        // Prepare test data
        UsuarioExt user = new UsuarioExt();
        user.setPegeId(1);
        user.setLogin("sarmero");
        user.setCorreoElectronico("sebarmero@gmail.com");
        user.setPassword("12345");
        

        // Call the build method
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);

        // Assertions
        assertNotNull(userDetails);
        assertEquals(1L, userDetails.getId());
        assertEquals("testuser", userDetails.getUsername());
        assertEquals("test@example.com", userDetails.getEmail());
        assertEquals("testpassword", userDetails.getPassword());

        List<SimpleGrantedAuthority> expectedAuthorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        assertEquals(expectedAuthorities, userDetails.getAuthorities());
    }

    // Write more test methods for other scenarios
}
