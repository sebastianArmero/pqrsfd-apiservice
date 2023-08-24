package com.smartcampus.repositories.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.TipoTipologia;

class TipoTipologiaJDBCRepositoryImplTest {



@InjectMocks
private TipoTipologiaJDBCRepositoryImpl tipoTipologiaRepository;

@Mock
private JdbcTemplate jdbcTemplate;

@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);
    tipoTipologiaRepository = new TipoTipologiaJDBCRepositoryImpl(jdbcTemplate);
}
    @Test
    void testCreate() {
        // Arrange
        TipoTipologia tipoTipologia = new TipoTipologia();
        // Set properties of tipoTipologia
        
        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<PreparedStatementCallback<Boolean>> callbackCaptor =
                ArgumentCaptor.forClass(PreparedStatementCallback.class);

        when(jdbcTemplate.execute(sqlCaptor.capture(), callbackCaptor.capture())).thenReturn(true);

        // Act
        tipoTipologiaRepository.create(tipoTipologia);

        // Assert
        assertEquals(1, sqlCaptor.getAllValues().size());
        assertEquals(1, callbackCaptor.getAllValues().size());

        String capturedSql = sqlCaptor.getValue();
        assertTrue(capturedSql.contains("INSERT INTO public.tb_tipotipologia"));

        PreparedStatementCallback<Boolean> capturedCallback = callbackCaptor.getValue();
        assertNotNull(capturedCallback);
        try {
			assertTrue(capturedCallback.doInPreparedStatement(mock(PreparedStatement.class)));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Add more assertions as needed
    }
}