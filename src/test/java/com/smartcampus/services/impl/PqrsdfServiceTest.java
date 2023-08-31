package com.smartcampus.services.impl;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.PegeIdDTO;
import com.smartcampus.models.Pqrsdf;
import com.smartcampus.models.TermCond;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.repositories.IPqrsdfRepository;


class PqrsdfServiceTest {

    @Mock
    private IPqrsdfRepository pqrsdfRepository;

    @InjectMocks
    private PqrsdfService pqrsdfService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        Pqrsdf pqrsdf = new Pqrsdf();
        // Set properties for pqrsdf
        
        when(pqrsdfRepository.createPqrsdf(pqrsdf)).thenReturn(1L);

        pqrsdfService.create(pqrsdf);

        verify(pqrsdfRepository).createPqrsdf(pqrsdf);
    }

    @Test
    void testShowAll() {
        List<Pqrsdf> pqrsdfList = new ArrayList<>();
        // Add Pqrsdf objects to pqrsdfList
        
        when(pqrsdfRepository.showAll()).thenReturn(pqrsdfList);

        List<Pqrsdf> result = pqrsdfService.showAll();

        verify(pqrsdfRepository).showAll();
        // Assert that 'result' contains the expected Pqrsdf objects
    }

    @Test
    void testFindByPegeId() {
        PegeIdDTO pegeIdDTO = new PegeIdDTO();
        // Set properties for pegeIdDTO
        
        List<Pqrsdf> pqrsdfList = new ArrayList<>();
        // Add Pqrsdf objects to pqrsdfList
        
        when(pqrsdfRepository.findByPegeId(pegeIdDTO)).thenReturn(pqrsdfList);

        List<Pqrsdf> result = pqrsdfService.findByPegeId(pegeIdDTO);

        verify(pqrsdfRepository).findByPegeId(pegeIdDTO);
        // Assert that 'result' contains the expected Pqrsdf objects
    }

    @Test
    void testFindByIdentificacion() {
        UserIdentificacionDTO identificacionDTO = new UserIdentificacionDTO();
        // Set properties for identificacionDTO
        
        List<Pqrsdf> pqrsdfList = new ArrayList<>();
        // Add Pqrsdf objects to pqrsdfList
        
        when(pqrsdfRepository.findByIdentificacion(identificacionDTO)).thenReturn(pqrsdfList);

        List<Pqrsdf> result = pqrsdfService.findByIdentificacion(identificacionDTO);

        verify(pqrsdfRepository).findByIdentificacion(identificacionDTO);
        // Assert that 'result' contains the expected Pqrsdf objects
    }



    @Test
    void testAceptarTermCond() {
        UserIdentificacionDTO userIdentificacionDTO = new UserIdentificacionDTO();
        // Set properties for userIdentificacionDTO
        
        pqrsdfService.aceptarTermCond(userIdentificacionDTO);

        
    }

    // Add more test methods for other service methods

}
