package com.smartcampus.services.impl;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.repositories.IUsuarioExtRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UsuarioExtServiceTest {

    @InjectMocks
    private UsuarioExtService usuarioExtService;

    @Mock
    private IUsuarioExtRepository usuarioExtRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testValidateByIdentificacion_Valid() {
        // Arrange
        UserIdentificacionDTO identificacion = new UserIdentificacionDTO();
        identificacion.setIdentificacion("1113540496");
        when(usuarioExtRepository.validateByIdentificacion(identificacion.getIdentificacion())).thenReturn(true);

        // Act
        SimpleObjectResponse response = usuarioExtService.validateByIdentificacion(identificacion);

        // Assert
        assertEquals(200, response.getCodigo());
        assertEquals("Usuario Encontrado", response.getMensaje());
    }

    @Test
    public void testValidateByIdentificacion_Invalid() {
        // Arrange
        UserIdentificacionDTO identificacion = new UserIdentificacionDTO();
        identificacion.setIdentificacion("987654321");
        when(usuarioExtRepository.validateByIdentificacion(identificacion.getIdentificacion())).thenReturn(false);

        // Act
        SimpleObjectResponse response = usuarioExtService.validateByIdentificacion(identificacion);

        // Assert
        assertEquals(400, response.getCodigo());
        assertEquals("Usuario no Encontrado", response.getMensaje());
    }

    // You can add more test methods for other functionalities if needed
}
