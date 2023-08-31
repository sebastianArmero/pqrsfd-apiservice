package com.smartcampus.services.impl;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.Glosario;
import com.smartcampus.repositories.IGlosarioRepository;


class GlosarioServiceTest {

    @Mock
    private IGlosarioRepository glosarioRepository;

    @InjectMocks
    private GlosarioService glosarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        Glosario glosario = new Glosario();
        // Set properties for glosario

        glosarioService.create(glosario);

        verify(glosarioRepository).create(glosario);
    }

    @Test
    void testShowAll() {
        List<Glosario> glosarioList = new ArrayList<>();
        // Add Glosario objects to glosarioList

        when(glosarioRepository.showAll()).thenReturn(glosarioList);

        List<Glosario> result = glosarioService.showAll();

        verify(glosarioRepository).showAll();
        // Assert that 'result' contains the expected Glosario objects
    }

    @Test
    void testShowById() {
        Long id = 1L;
        Glosario glosario = new Glosario();
        // Set properties for glosario

        when(glosarioRepository.showById(id)).thenReturn(glosario);

        Glosario result = glosarioService.showById(id);

        verify(glosarioRepository).showById(id);
        // Assert that 'result' is the expected Glosario object
    }

    // You can add more test methods for other service methods

}
