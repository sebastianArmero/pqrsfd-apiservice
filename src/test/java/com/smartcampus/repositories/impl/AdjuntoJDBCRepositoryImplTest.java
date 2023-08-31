package com.smartcampus.repositories.impl;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Adjunto;
import com.smartcampus.security.exceptions.BadRequestException;

public class AdjuntoJDBCRepositoryImplTest {

    @InjectMocks
    private AdjuntoJDBCRepositoryImpl adjuntoRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	@Test
    public void testCreate() {
        // Prepare test data
        Adjunto adjunto = new Adjunto();
        adjunto.setRequId(1);
        adjunto.setAdjuNombre("Test Adjunto");
        adjunto.setAdjuRegistradoPor("Test User");
        adjunto.setAdjProcesoAuditoria("Test Process");

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.execute(anyString(), any(PreparedStatementCallback.class))).thenReturn(true);

        // Call the method to test
        adjuntoRepository.create(adjunto);

        // Assertions
        verify(jdbcTemplate).execute(anyString(), any(PreparedStatementCallback.class));
    }

    @Test
    public void testCreateDuplicateKeyException() {
        // Prepare test data
        Adjunto adjunto = new Adjunto();
        // Set required properties

        // Mock the behavior of JdbcTemplate to throw DuplicateKeyException
        when(jdbcTemplate.execute(anyString(), any(PreparedStatementCallback.class)))
            .thenThrow(new DuplicateKeyException("Duplicate key violation"));

        // Call the method to test
        assertThrows(BadRequestException.class, () -> adjuntoRepository.create(adjunto));
    }

    // Add more test methods to further increase coverage
}
