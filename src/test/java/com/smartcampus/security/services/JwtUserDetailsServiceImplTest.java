package com.smartcampus.security.services;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcampus.security.models.JwtUser;
import com.smartcampus.security.repositories.impl.UserJDBCRepositoryImpl;

public class JwtUserDetailsServiceImplTest {

    @InjectMocks
    private JwtUserDetailsServiceImpl userDetailsService;

    @Mock
    private UserJDBCRepositoryImpl userRepository;

    @Test
    public void testLoadUserByUsername() {
        // Prepare test data
        String login = "testuser";
        UserDetails userDetails = new JwtUser();

        // Mock the behavior of UserRepository
        when(userRepository.selectByLogin(login)).thenReturn((JwtUser) userDetails);

        // Call the method to test
        UserDetails result = userDetailsService.loadUserByUsername(login);

        // Assertions
        assertNotNull(result);
        assertEquals(userDetails, result);
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        // Prepare test data
        String login = "nonexistentuser";

        // Mock the behavior of UserRepository to throw UsernameNotFoundException
        when(userRepository.selectByLogin(login)).thenThrow(new UsernameNotFoundException("User not found"));

        // Call the method to test
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(login));
    }

    @Test
    public void testLoadUserByUsernameEmptyLogin() {
        // Prepare test data
        String login = "sarmero";

        // Call the method to test
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(login));
    }

    @Test
    public void testLoadUserByUsernameNullLogin() {
        // Prepare test data
        String login = null;

        // Call the method to test
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(login));
    }

    // Add more test methods for other scenarios
}