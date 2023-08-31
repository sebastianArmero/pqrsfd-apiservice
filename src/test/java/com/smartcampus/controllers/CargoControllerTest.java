package com.smartcampus.controllers;
import static org.mockito.Mockito.*;

import com.smartcampus.controllers.CargoController;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Cargo;
import com.smartcampus.services.ICargoService;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CargoControllerTest {

    @Test
    public void testShowAll() {
        // Arrange
        ICargoService cargoService = mock(ICargoService.class);

        // Create a mocked list of Cargo objects
        List<Cargo> mockedCargoList = new ArrayList<>();
        mockedCargoList.add(new Cargo(/* Initialize Cargo object with necessary properties */));
        // Add more Cargo objects to the list if needed

        when(cargoService.showAll()).thenReturn(mockedCargoList);

  
    }
}