package com.smartcampus.services.impl;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.repositories.IDiasInhabilesRepository;
import com.smartcampus.security.exceptions.BadRequestException;


class DiasInhabilesServiceTest {

    @Mock
    private IDiasInhabilesRepository diasInhabilesRepository;

    @InjectMocks
    private DiasInhabilesService diasInhabilesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() throws BadRequestException {
        DiasInhabiles diasInhabiles = new DiasInhabiles();
        // Set properties for diasInhabiles

        doNothing().when(diasInhabilesRepository).create(diasInhabiles);

        diasInhabilesService.create(diasInhabiles);

        verify(diasInhabilesRepository).create(diasInhabiles);
    }

    @Test
    void testCreateWithNullDiasInhabiles() {
        // Perform assertions or exception handling for the expected exception
        // ...
    }

    @Test
    void testCreateDias() throws BadRequestException {
        List<DiasInhabiles> diasList = new ArrayList<>();
        DiasInhabiles dias1 = new DiasInhabiles();
        // Set properties for dias1
        diasList.add(dias1);

        doNothing().when(diasInhabilesRepository).create(dias1);

        diasInhabilesService.createDias(diasList);

        verify(diasInhabilesRepository, times(1)).create(dias1);
        // You can add more assertions here to verify the behavior
    }

    @Test
    void testCreateDiasWithNullList() {
        // Perform assertions or exception handling for the expected exception
        // ...
    }

    // You can add more test methods for other service methods

}
