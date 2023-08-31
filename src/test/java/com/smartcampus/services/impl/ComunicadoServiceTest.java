package com.smartcampus.services.impl;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.Comunicado;
import com.smartcampus.repositories.IComunicadoRepository;
import com.smartcampus.security.exceptions.BadRequestException;


class ComunicadoServiceTest {

    @Mock
    private IComunicadoRepository comunicadoRepository;

    @InjectMocks
    private ComunicadoService comunicadoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() throws BadRequestException {
        Comunicado comunicado = new Comunicado();
        // Set properties for comunicado

        doNothing().when(comunicadoRepository).create(comunicado);

        comunicadoService.create(comunicado);

        verify(comunicadoRepository).create(comunicado);
    }

    @Test
    void testCreateWithNullComunicado() {
        // Perform assertions or exception handling for the expected exception
        // ...
    }

    @Test
    void testShowAll() {
        List<Comunicado> expectedComunicadoList = new ArrayList<>();
        // Add sample Comunicado objects to expectedComunicadoList

        when(comunicadoRepository.showAll()).thenReturn(expectedComunicadoList);

        List<Comunicado> actualComunicadoList = comunicadoService.showAll();

        // Perform assertions to compare expectedComunicadoList and actualComunicadoList
        // ...
    }

    // You can add more test methods for other service methods

}
