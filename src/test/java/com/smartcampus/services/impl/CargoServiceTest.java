package com.smartcampus.services.impl;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.Cargo;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.security.exceptions.BadRequestException;


class CargoServiceTest {

    @Mock
    private ICargoRepository cargoRepository;

    @InjectMocks
    private CargoService cargoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() throws BadRequestException {
        Cargo cargo = new Cargo();
        // Set properties for cargo

        doNothing().when(cargoRepository).create(cargo);

        cargoService.create(cargo);

        // Verify the behavior using Mockito.verify if necessary
        verify(cargoRepository).create(cargo);
    }

    @Test
    void testCreateWithNullCargo() {
        // Perform assertions or exception handling for the expected exception
        // ...
    }

    @Test
    void testShowAll() {
        List<Cargo> expectedCargoList = new ArrayList<>();
        // Add sample Cargo objects to expectedCargoList
        
        when(cargoRepository.showAll()).thenReturn(expectedCargoList);

        List<Cargo> actualCargoList = cargoService.showAll();

        // Perform assertions to compare expectedCargoList and actualCargoList
        // ...
    }

    // You can add more test methods for other service methods

}
