package com.smartcampus.controllers;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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
import com.smartcampus.models.Encuesta;
import com.smartcampus.services.IEncuestaService;

@SpringJUnitConfig
@WebMvcTest(EncuestaController.class)
public class EncuestaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IEncuestaService encuestaService;

    private List<Encuesta> mockEncuestaList;

    @BeforeEach
    public void setup() {
        mockEncuestaList = new ArrayList<>();
        // Add mock Encuesta objects to the list
    }

    @Test
    public void testShowAll() throws Exception {
        when(encuestaService.showAll()).thenReturn(mockEncuestaList);

        mockMvc.perform(MockMvcRequestBuilders.get("/encuesta/api/showAll")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Objetos obtenidos con éxito"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(mockEncuestaList.size()));
    }

    @Test
    public void testCreate() throws Exception {
        doNothing().when(encuestaService).create(any(Encuesta.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/encuesta/api/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(new Encuesta())))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Encuesta creada con éxito"));
    }

    // Similar tests for other methods in the controller
}
