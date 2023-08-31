package com.smartcampus.services.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.PqrsfdProm;
import com.smartcampus.repositories.IPqrsfdPromRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PqrsfdPromServiceTest {

    @InjectMocks
    private PqrsfdPromService pqrsfdPromService;

    @Mock
    private IPqrsfdPromRepository pqrsfdPromRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowByAnio() {
        // Arrange
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 12, 31);
        List<PqrsfdProm> expectedList = new ArrayList<>();
        when(pqrsfdPromRepository.showByAnios(fechaInicio, fechaFinal)).thenReturn(expectedList);

        // Act
        List<PqrsfdProm> result = pqrsfdPromService.showByAnio(fechaInicio, fechaFinal);

        // Assert
        assertEquals(expectedList, result);
    }

    // You can add more test methods for other functionalities if needed
}
