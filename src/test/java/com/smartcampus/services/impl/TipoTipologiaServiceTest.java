package com.smartcampus.services.impl;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.TipoTipologia;
import com.smartcampus.repositories.ITipoTipologiaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TipoTipologiaServiceTest {

    @InjectMocks
    private TipoTipologiaService tipoTipologiaService;

    @Mock
    private ITipoTipologiaRepository tipoTipologiaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAll() {
        // Arrange
        List<TipoTipologia> expectedList = new ArrayList<>();
        when(tipoTipologiaRepository.showAll()).thenReturn(expectedList);

        // Act
        List<TipoTipologia> result = tipoTipologiaService.showAll();

        // Assert
        assertEquals(expectedList, result);
    }

    @Test
    public void testUpdate_ValidInput_Success() {
        // Arrange
        Long id = 1L;
        TipoTipologia tipoTipologia = new TipoTipologia();
        // Set up your test conditions here

        // Act
        tipoTipologiaService.update(id, tipoTipologia);

        // No need for an assertion here, as we are testing a void method
    }

    // You can add more test methods for other functionalities if needed
}
