package com.smartcampus.services.impl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.PqrsfdAsun;
import com.smartcampus.repositories.IPqrsfdAsunRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PqrsfdAsunServiceTest {

    @InjectMocks
    private PqrsfdAsunService pqrsfdAsunService;

    @Mock
    private IPqrsfdAsunRepository pqrsfdAsunRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAll() {
        // Arrange
        List<PqrsfdAsun> expectedList = new ArrayList<>();
        when(pqrsfdAsunRepository.showAll()).thenReturn(expectedList);

        // Act
        List<PqrsfdAsun> result = pqrsfdAsunService.showAll();

        // Assert
        assertEquals(expectedList, result);
    }

    @Test
    public void testShowById() {
        // Arrange
        long id = 1;
        PqrsfdAsun expectedPqrsfdAsun = new PqrsfdAsun();
        when(pqrsfdAsunRepository.showById(id)).thenReturn(expectedPqrsfdAsun);

        // Act
        PqrsfdAsun result = pqrsfdAsunService.showById(id);

      
    }

    @Test
    public void testShowByAnio() {
        // Arrange
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 12, 31);
        List<PqrsfdAsun> expectedList = new ArrayList<>();
        when(pqrsfdAsunRepository.showByAnio(fechaInicio, fechaFinal)).thenReturn(expectedList);

        // Act
        List<PqrsfdAsun> result = pqrsfdAsunService.showByAnio(fechaInicio, fechaFinal);

        // Assert
        assertEquals(expectedList, result);
    }
}
