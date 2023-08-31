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
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.UserDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.services.IUsuarioExtService;
import com.smartcampus.security.exceptions.NotFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UsuarioExtControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UsuarioExtController usuarioExtController;

    @Mock
    private IUsuarioExtService usuarioExtService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioExtController).build();
    }

    @Test
    public void testFindByIdentificacion() throws Exception {
        UsuarioExt usuarioExt = new UsuarioExt();
        UserIdentificacionDTO identificacion = new UserIdentificacionDTO();
        identificacion.setIdentificacion("123456789");

        when(usuarioExtService.findByIdentificacion(any(UserIdentificacionDTO.class))).thenReturn(usuarioExt);

        mockMvc.perform(post("/usuarioext/api/findByIdentificacion")
                .content(new ObjectMapper().writeValueAsString(identificacion))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
 //               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
 //               .andExpect(jsonPath("$.status").value(HttpStatus.OK.value()))
 //               .andExpect(jsonPath("$.message").value("Objetos obtenidos con éxito"));

        verify(usuarioExtService, times(1)).findByIdentificacion(any(UserIdentificacionDTO.class));
    }

    @Test
    public void testValidateByIdentificacion() throws Exception {
        UserIdentificacionDTO identificacion = new UserIdentificacionDTO();
        identificacion.setIdentificacion("123456789");

        SimpleObjectResponse response = new SimpleObjectResponse(200, "Documento válido", true);
        when(usuarioExtService.validateByIdentificacion(any(UserIdentificacionDTO.class))).thenReturn(response);

        mockMvc.perform(post("/usuarioext/api/validatebyidentificacion")
                .content(new ObjectMapper().writeValueAsString(identificacion))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.status").value(HttpStatus.OK.value()))
//                .andExpect(jsonPath("$.message").value("Documento válido"))
//                .andExpect(jsonPath("$.value").value(true));

        verify(usuarioExtService, times(1)).validateByIdentificacion(any(UserIdentificacionDTO.class));
    }

    @Test
    public void testValidatebyLogin() throws Exception {
        UserDTO username = new UserDTO();
        username.setUsername("john_doe");

        SimpleObjectResponse response = new SimpleObjectResponse(200, "Usuario válido", true);
        when(usuarioExtService.validateByLogin(any(UserDTO.class))).thenReturn(response);

        mockMvc.perform(post("/usuarioext/api/validatebyLogin")
                .content(new ObjectMapper().writeValueAsString(username))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
               // .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$.status").value(HttpStatus.OK.value()))
               // .andExpect(jsonPath("$.message").value("Usuario válido"))
               // .andExpect(jsonPath("$.value").value(true));

        verify(usuarioExtService, times(1)).validateByLogin(any(UserDTO.class));
    }

    // Add more test cases for other methods

}





