package com.smartcampus.controllers;
import static org.mockito.Mockito.*;

import java.util.Collections;
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
import com.smartcampus.models.Funcionario;
import com.smartcampus.services.IFuncionarioService;

@SpringJUnitConfig
@WebMvcTest(FuncionarioController.class)
public class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IFuncionarioService funcionarioService;

    private Funcionario mockFuncionario;

    @BeforeEach
    public void setup() {
        // Create a mock Funcionario object
        mockFuncionario = new Funcionario();
        mockFuncionario.setUnidId(1L);
        // Set other properties of the mock Funcionario object
    }

    @Test
    public void testShowAll() throws Exception {
        when(funcionarioService.showAll()).thenReturn(Collections.singletonList(mockFuncionario));

        mockMvc.perform(MockMvcRequestBuilders.get("/funcionario/api/showAll")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Objetos obtenidos con éxito"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(1));
    }

    @Test
    public void testShowByIdFunc() throws Exception {
        Long funcionarioId = 1L;
        when(funcionarioService.showByIdFunc(funcionarioId)).thenReturn((List<Funcionario>) mockFuncionario);

        mockMvc.perform(MockMvcRequestBuilders.get("/funcionario/api/showByIdFunc/{id}", funcionarioId)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Objetos obtenidos con éxito"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(funcionarioId));
    }

    // Similar tests for other methods in the controller
}