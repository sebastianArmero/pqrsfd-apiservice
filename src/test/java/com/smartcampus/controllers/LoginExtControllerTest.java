package com.smartcampus.controllers;
import static org.mockito.Mockito.*;

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
import com.smartcampus.models.CrearUserExtDTO;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.services.ILoginUserExtService;

@SpringJUnitConfig
@WebMvcTest(LoginExtController.class)
public class LoginExtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ILoginUserExtService loginUserExtService;

    @Test
    public void testValidateIdentificacion() throws Exception {
        String identificacion = "1113540460"; // Replace with your test value
        SimpleObjectResponse mockResponse = new SimpleObjectResponse(200, "Documento registrado", null);
        when(loginUserExtService.validateIdentificacion(identificacion)).thenReturn(mockResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/login/api/validateidentificacion")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(new UserIdentificacionDTO(identificacion)))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Documento registrado"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(mockResponse.getValor()));
    }

    @Test
    public void testRegistrarUsuarioExt() throws Exception {
        CrearUserExtDTO mockUsuarioExt = new CrearUserExtDTO(); // Create a mock DTO object
        doNothing().when(loginUserExtService).create(mockUsuarioExt);

        mockMvc.perform(MockMvcRequestBuilders.post("/login/api/registrarusuarioext")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(mockUsuarioExt))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Usuario Externo creado con éxito"));
    }

    // Similar tests for other methods in the controller
}
