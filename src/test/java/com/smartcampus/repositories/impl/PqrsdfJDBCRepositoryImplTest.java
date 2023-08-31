package com.smartcampus.repositories.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Pqrsdf;
import com.smartcampus.security.exceptions.BadRequestException;

public class PqrsdfJDBCRepositoryImplTest {

	   private JdbcTemplate jdbcTemplate;
	    private PqrsdfJDBCRepositoryImpl pqrsdfRepository;

	    @BeforeEach
	    public void setup() {
	        jdbcTemplate = mock(JdbcTemplate.class);
	        pqrsdfRepository = new PqrsdfJDBCRepositoryImpl(); // Inject JdbcTemplate through constructor
	    }

    @Test
    public void testCreatePqrsdf() throws SQLException {
        Pqrsdf pqrsdf = new Pqrsdf();
        pqrsdf.setPqrsPegeidUsuario((int) 1L);
        pqrsdf.setPqrsPegeidreporta(2);
        // Set other properties...

        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        @SuppressWarnings("unchecked")
		ArgumentCaptor<PreparedStatementCallback<Boolean>> callbackCaptor =
                ArgumentCaptor.forClass(PreparedStatementCallback.class);

        when(jdbcTemplate.execute(sqlCaptor.capture(), callbackCaptor.capture())).thenReturn(true);

     
    }

    @Test
    public void testCreateDuplicatePqrsdf() throws SQLException {
        Pqrsdf pqrsdf = new Pqrsdf();
        pqrsdf.setPqrsPegeidUsuario((int) 1L);
        pqrsdf.setPqrsPegeidreporta(2);
        // Set other properties...

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class)))
                .thenThrow(new DuplicateKeyException("Duplicate key"));

     
    }

    // More test methods for other repository methods...
}
