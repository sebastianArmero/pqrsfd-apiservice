package com.smartcampus.services.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IPqrsfdRecRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PqrsfdRecServiceTest {

    @InjectMocks
    private PqrsfdRecService pqrsfdRecService;

    @Mock
    private IPqrsfdRecRepository pqrsfdRecRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowByAnio() {
        // Arrange
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 12, 31);
        List<PqrsfdRec> expectedList = new ArrayList<>();
        when(pqrsfdRecRepository.showByAnio(fechaInicio, fechaFinal)).thenReturn(expectedList);

        // Act
        List<PqrsfdRec> result = pqrsfdRecService.showByAnio(fechaInicio, fechaFinal);

        // Assert
        assertEquals(expectedList, result);
    }

    // You can add more test methods for other functionalities if needed
}
