package com.smartcampus.controllers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.TipoTipologia;
import com.smartcampus.services.ITipoTipologiaService;
import com.smartcampus.security.exceptions.NotFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TipoTipologiaControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TipoTipologiaController tipoTipologiaController;

    @Mock
    private ITipoTipologiaService tipoTipologiaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tipoTipologiaController).build();
    }

    @Test
    public void testShowAll() throws Exception {
        List<TipoTipologia> tipoTipologiaList = new ArrayList<>();

        when(tipoTipologiaService.showAll()).thenReturn(tipoTipologiaList);

        mockMvc.perform(get("/tipoTipologia/api/showAll"))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.status").value(HttpStatus.OK.value()))
//                .andExpect(jsonPath("$.message").value("Objetos obtenidos con éxito"));

        verify(tipoTipologiaService, times(1)).showAll();
    }

    @Test
    public void testCreate() throws Exception {
        TipoTipologia tipoTipologia = new TipoTipologia();

        doNothing().when(tipoTipologiaService).create(any(TipoTipologia.class));

        mockMvc.perform(post("/tipoTipologia/api/create")
                .content(new ObjectMapper().writeValueAsString(tipoTipologia))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(jsonPath("$.status").value(HttpStatus.OK.value()))
//                .andExpect(jsonPath("$.message").value("Tipologia creada con éxito"));

        verify(tipoTipologiaService, times(1)).create(any(TipoTipologia.class));
    }

    @Test
    public void testCreateNotFound() throws Exception {
        TipoTipologia tipoTipologia = new TipoTipologia();

        doThrow(NotFoundException.class).when(tipoTipologiaService).create(any(TipoTipologia.class));

        mockMvc.perform(post("/tipoTipologia/api/create")
                .content(new ObjectMapper().writeValueAsString(tipoTipologia))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(tipoTipologiaService, times(1)).create(any(TipoTipologia.class));
    }

    // Add more test cases for other methods

}




