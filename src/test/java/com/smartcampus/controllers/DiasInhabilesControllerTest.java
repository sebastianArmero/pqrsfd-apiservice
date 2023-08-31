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
import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.services.IDiasInhabilesService;

@SpringJUnitConfig
@WebMvcTest(DiasInhabilesController.class)
public class DiasInhabilesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IDiasInhabilesService diasInhabilesService;

    @Test
    public void testShowAll() throws Exception {
        // Mocking the service response
        List<DiasInhabiles> mockDiasInhabilesList = new ArrayList<>();
        mockDiasInhabilesList.add(new DiasInhabiles(/* Initialize the DiasInhabiles object */));
        when(diasInhabilesService.showAll()).thenReturn(mockDiasInhabilesList);

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/diasInhabiles/api/showAll")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200)) // Ensure the expected status code
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Objetos obtenidos con éxito"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].propertyName").value(mockDiasInhabilesList/* Expected value from mock */));
    }

    @Test
    public void testCreateDias() throws Exception {
        // Mocking the service response
        doNothing().when(diasInhabilesService).createDias(anyList());

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.post("/diasInhabiles/api/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(new ArrayList<>())))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("dias inhabiles creado con éxito"));
    }

    // Similar tests for other methods in the controller
}
                                                                                                