package com.smartcampus.services.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.PqrsfdEst;
import com.smartcampus.repositories.IPqrsfdEstRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PqrsfdEstServiceTest {

    @InjectMocks
    private PqrsfdEstService pqrsfdEstService;

    @Mock
    private IPqrsfdEstRepository pqrsfdEstRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAll() {
        // Arrange
        List<PqrsfdEst> expectedList = new ArrayList<>();
        when(pqrsfdEstRepository.showAll()).thenReturn(expectedList);

        // Act
        List<PqrsfdEst> result = pqrsfdEstService.showAll();

        // Assert
        assertEquals(expectedList, result);
    }

    @Test
    public void testShowById() {
        // Arrange
        long id = 1;
        PqrsfdEst expectedPqrsfdEst = new PqrsfdEst();
        when(pqrsfdEstRepository.showById(id)).thenReturn(expectedPqrsfdEst);

        // Act
        PqrsfdEst result = pqrsfdEstService.showById(id);

        // Assert
        assertEquals(expectedPqrsfdEst, result);
    }

    @Test
    public void testShowByAnio() {
        // Arrange
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 12, 31);
        List<PqrsfdEst> expectedList = new ArrayList<>();
        when(pqrsfdEstRepository.showByAnio(fechaInicio, fechaFinal)).thenReturn(expectedList);

        // Act
        List<PqrsfdEst> result = pqrsfdEstService.showByAnio(fechaInicio, fechaFinal);

        // Assert
        assertEquals(expectedList, result);
    }
}
