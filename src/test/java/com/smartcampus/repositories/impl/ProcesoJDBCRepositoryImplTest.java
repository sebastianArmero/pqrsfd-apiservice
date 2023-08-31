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

import com.smartcampus.models.Proceso;
import com.smartcampus.security.exceptions.BadRequestException;

class ProcesoJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ProcesoJDBCRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        Proceso proceso = new Proceso();
        proceso.setProcNombre("Nombre del proceso");
        proceso.setProcDescripcion("Descripción del proceso");
        proceso.setProcRegistradopor("UsuarioRegistrador");
        proceso.setProcProcesoauditoria("Auditoría del proceso");

        when(jdbcTemplate.execute(anyString(), any(PreparedStatementCallback.class))).thenReturn(true);

        repository.create(proceso);

        // Verify the behavior using Mockito.verify if necessary
        // ...
    }

    @Test
    void testCreateWithDuplicateKeyException() {
        Proceso proceso = new Proceso();
        proceso.setProcNombre("Nombre del proceso");
        proceso.setProcDescripcion("Descripción del proceso");
        proceso.setProcRegistradopor("UsuarioRegistrador");
        proceso.setProcProcesoauditoria("Auditoría del proceso");

        when(jdbcTemplate.execute(anyString(), any(PreparedStatementCallback.class)))
            .thenThrow(new DuplicateKeyException("Duplicate key violation"));

        // Perform assertions or exception handling for the expected exception
        // ...
    }

    // Add more test methods for other repository methods
}
