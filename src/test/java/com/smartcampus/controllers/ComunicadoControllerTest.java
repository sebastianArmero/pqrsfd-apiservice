package com.smartcampus.controllers;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Comunicado;
import com.smartcampus.services.IComunicadoService;

@SpringJUnitConfig
@WebMvcTest(ComunicadoController.class)
public class ComunicadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IComunicadoService comunicadoService;

    @Test
    public void testShowAll() throws Exception {
        // Mocking the service response
        List<Comunicado> mockComunicados = new ArrayList<>();
        mockComunicados.add(new Comunicado(/* Initialize the Comunicado object */));
        when(comunicadoService.showAll()).thenReturn(mockComunicados);

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/comunicado/api/showAll")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200)) // Ensure the expected status code
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Objetos obtenidos con éxito"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].propertyName").value(mockComunicados/* Expected value from mock */));
    }
}