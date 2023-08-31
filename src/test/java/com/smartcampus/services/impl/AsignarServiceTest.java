package com.smartcampus.services.impl;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.Asignar;
import com.smartcampus.repositories.IAsignarRepository;
import com.smartcampus.security.exceptions.BadRequestException;

class AsignarServiceTest {

    @Mock
    private IAsignarRepository asignarRepository;

    @InjectMocks
    private AsignarService asignarService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() throws BadRequestException {
        Asignar asignar = new Asignar();
        // Set properties for asignar

        doNothing().when(asignarRepository).create(asignar);

        asignarService.create(asignar);

        // Verify the behavior using Mockito.verify if necessary
        verify(asignarRepository).create(asignar);
    }

    @Test
    void testCreateWithNullAsignar() {
        // Perform assertions or exception handling for the expected exception
        // ...
    }

    @Test
    void testUpdate() {
        Asignar asignar = new Asignar();
        // Set properties for asignar
        String requeEstado = "SomeStatus";

        doNothing().when(asignarRepository).update(asignar, requeEstado);

        asignarService.update(asignar, requeEstado);

        // Verify the behavior using Mockito.verify if necessary
        verify(asignarRepository).update(asignar, requeEstado);
    }

    @Test
    void testUpdateWithNullRequeEstado() {
        // Perform assertions or exception handling for the expected exception
        // ...
    }

    @Test
    void testDelete() {
        Long id = 1L;

        doNothing().when(asignarRepository).delete(id);

        asignarService.delete(id);

        // Verify the behavior using Mockito.verify if necessary
        verify(asignarRepository).delete(id);
    }

    // Add more test methods for other service methods
}
