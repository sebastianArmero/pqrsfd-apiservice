package com.smartcampus.repositories.impl;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Comunicado;
import com.smartcampus.models.Requerimiento;
import com.smartcampus.security.exceptions.BadRequestException;

@ExtendWith(MockitoExtension.class)
public class ComunicadoJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ComunicadoJDBCRepositoryImpl comunicadoRepository;

    @Test
    public void testCreateComunicado_Success1() {
        Comunicado comunicado = new Comunicado();
        comunicado.setRequId(1);
        comunicado.setComuDescripcion("Test Comunicado");
        comunicado.setComuRegistradopor("Test User");
        comunicado.setComuRevisadopor("Test Reviewer");
        comunicado.setComuEstado("Pending");
        comunicado.setComuProcesoauditoria("Test Process");
        comunicado.setComuObservacion("Test Observation");
        comunicado.setPegeId("12345");

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class))).thenReturn(true);

        comunicadoRepository.create(comunicado);

        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
        // Additional verification/assertions can be added
    }

    @Test
    public void testCreateComunicado_DuplicateKeyException() {
        Comunicado comunicado = new Comunicado();
        comunicado.setRequId(1);
        // Other properties...

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class)))
                .thenThrow(new DuplicateKeyException("Duplicate key"));

        try {
            comunicadoRepository.create(comunicado);
        } catch (BadRequestException e) {
            // Exception should be thrown
        }

        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
        // Additional verification/assertions can be added
    }

    @Test
    public void testCreateComunicado_Success() {
        Comunicado comunicado = new Comunicado();
        // set other properties of the comunicado

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class))).thenReturn(true);

        comunicadoRepository.create(comunicado);

        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
        // Additional verification/assertions can be added

        // Now, retrieve the updated requerimiento from the database and verify its estado
        Requerimiento updatedRequerimiento = retrieveRequerimientoFromDatabase(comunicado.getRequId());
        assertTrue(updatedRequerimiento.getRequEstado().equals("RESUELTO"));
    }

    // This method simulates retrieving a requerimiento from the database by its ID
    private Requerimiento retrieveRequerimientoFromDatabase(int requerimientoId) {
        // Implement this method to retrieve the requerimiento from your test database
        // You might need to use a test-specific database or mocking framework
        return null; // Replace with actual implementation
    }
}
