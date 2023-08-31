package com.smartcampus.repositories.impl;
import static org.mockito.ArgumentMatchers.*;
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

import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.security.exceptions.BadRequestException;

@ExtendWith(MockitoExtension.class)
public class DiasInhabilesJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private DiasInhabilesJDBCRepositoryImpl diasInhabilesRepository;

    @Test
    public void testCreateDiasInhabiles_Success() {
        DiasInhabiles diasInhabiles = new DiasInhabiles();
        diasInhabiles.setDiinFecha(new Date());
        diasInhabiles.setDiinRegistradopor("Test User");
        diasInhabiles.setDiinProcesoauditoria("Test Process");

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class))).thenReturn(true);

        diasInhabilesRepository.create(diasInhabiles);

        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
        // Additional verification/assertions can be added
    }

    @Test
    public void testCreateDiasInhabiles_DuplicateKeyException() {
        DiasInhabiles diasInhabiles = new DiasInhabiles();
        // Set properties...

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class)))
                .thenThrow(new DuplicateKeyException("Duplicate key"));

       

        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
        // Additional verification/assertions can be added
    }

    @Test
    public void testUpdateDiasInhabiles_Success() {
        Long id = 1L;
        DiasInhabiles diasInhabiles = new DiasInhabiles();
        diasInhabiles.setDiinEstado(true); // Set the boolean value

        when(jdbcTemplate.update(any(String.class), any(Object[].class))).thenReturn(1);

        
    }
}
