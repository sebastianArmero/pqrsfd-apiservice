package com.smartcampus.services.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.repositories.IPqrsfdCanRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PqrsfdCanServiceTest {

    @InjectMocks
    private PqrsfdCanService pqrsfdCanService;

    @Mock
    private IPqrsfdCanRepository pqrsfdCanRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAll() {
        // Arrange
        List<PqrsfdCan> expectedList = new ArrayList<>();
        when(pqrsfdCanRepository.showAll()).thenReturn(expectedList);

        // Act
        List<PqrsfdCan> result = pqrsfdCanService.showAll();

        // Assert
        assertEquals(expectedList, result);
    }

    @Test
    public void testShowById() {
        // Arrange
        long id = 1;
        PqrsfdCan expectedPqrsfdCan = new PqrsfdCan();
        when(pqrsfdCanRepository.showById(id)).thenReturn(expectedPqrsfdCan);

        // Act
        PqrsfdCan result = pqrsfdCanService.showById(id);

     
    }

    @Test
    public void testShowByAnio() {
        // Arrange
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 12, 31);
        List<PqrsfdCan> expectedList = new ArrayList<>();
        when(pqrsfdCanRepository.showByAnioshowByAnio(fechaInicio, fechaFinal)).thenReturn(expectedList);

        // Act
        List<PqrsfdCan> result = pqrsfdCanService.showByAnio(fechaInicio, fechaFinal);

        // Assert
        assertEquals(expectedList, result);
    }
}
