package com.smartcampus.services.impl;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.Proceso;
import com.smartcampus.repositories.IProcesoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProcesoServiceTest {

    @InjectMocks
    private ProcesoService procesoService;

    @Mock
    private IProcesoRepository procesoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAll() {
        // Arrange
        List<Proceso> expectedList = new ArrayList<>();
        when(procesoRepository.showAll()).thenReturn(expectedList);

        // Act
        List<Proceso> result = procesoService.showAll();

        // Assert
        assertEquals(expectedList, result);
    }

    // You can add more test methods for other functionalities if needed
}
