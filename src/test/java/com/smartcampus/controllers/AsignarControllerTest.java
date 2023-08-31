package com.smartcampus.controllers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
import com.smartcampus.models.Asignar;
import com.smartcampus.services.IAsignarService;
import com.smartcampus.security.exceptions.NotFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AsignarControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AsignarController asignarController;

    @Mock
    private IAsignarService asignarService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(asignarController).build();
    }

    @Test
    public void testShowByIdFunc() throws Exception {
      
        mockMvc.perform(get("/asignar/api/showByIdFunc/{id}", 1L))
                .andExpect(status().isOk());
               
        verify(asignarService, times(1)).showByIdFunc(anyLong());
    }

    @Test
    public void testCreate() throws Exception {
        Asignar asignar = new Asignar();
        // Set properties for asignar

        doNothing().when(asignarService).create(any(Asignar.class));

        mockMvc.perform(post("/asignar/api/create")
                .content(new ObjectMapper().writeValueAsString(asignar))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
               
        verify(asignarService, times(1)).create(any(Asignar.class));
    }

    @Test
    public void testDelete() throws Exception {
        long id = 1L;

        doNothing().when(asignarService).delete(eq(id));

        mockMvc.perform(delete("/asignar/api/delete/{id}", id))
                .andExpect(status().isOk());
               
        verify(asignarService, times(1)).delete(eq(id));
    }

    // Add more test cases for other methods

}
