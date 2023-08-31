package com.smartcampus.repositories.impl;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Trazabilidad;
import com.smartcampus.security.exceptions.BadRequestException;

class TrazabilidadJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TrazabilidadJDBCRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        Trazabilidad trazabilidad = new Trazabilidad();
        trazabilidad.setRequId(1);
        trazabilidad.setUsuaIdejecutor(2);
        trazabilidad.setUsuaIdasignado(3);
        trazabilidad.setTrazDescripcion("Descripción de la trazabilidad");
        trazabilidad.setTrazEstado("Estado de la trazabilidad");
        trazabilidad.setTrazRegistradopor("UsuarioRegistrador");
        trazabilidad.setTrazProcesoauditoria("Auditoría de la trazabilidad");

        when(jdbcTemplate.execute(anyString(), any(PreparedStatementCallback.class))).thenReturn(true);

        repository.create(trazabilidad);

        // Verify the behavior using Mockito.verify if necessary
        // ...
    }

    @Test
    void testCreateWithDuplicateKeyException() {
        Trazabilidad trazabilidad = new Trazabilidad();
        // Set properties for trazabilidad

        when(jdbcTemplate.execute(anyString(), any(PreparedStatementCallback.class)))
            .thenThrow(new DuplicateKeyException("Duplicate key violation"));

        // Perform assertions or exception handling for the expected exception
        // ...
    }

    // Add more test methods for other repository methods
}
