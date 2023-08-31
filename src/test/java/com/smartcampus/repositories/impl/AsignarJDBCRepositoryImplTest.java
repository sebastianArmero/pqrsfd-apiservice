package com.smartcampus.repositories.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Asignar;
import com.smartcampus.repositories.IAsignarRepository;
import com.smartcampus.repositories.rowmapper.AsignarRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

public class AsignarJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private IAsignarRepository asignarRepository = new AsignarJDBCRepositoryImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateSuccess() {
        Asignar asignar = new Asignar();
        // Initialize asignar properties

        doAnswer(invocation -> {
            PreparedStatementCallback<Boolean> callback = invocation.getArgument(1);
            callback.doInPreparedStatement((PreparedStatement) mock(PreparedStatement.class));
            return null;
        }).when(jdbcTemplate).execute(anyString(), any(PreparedStatementCallback.class));

        asignarRepository.create(asignar);

        // Verify that the execute method was called with correct arguments
        verify(jdbcTemplate).execute(anyString(), any(PreparedStatementCallback.class));
    }

    @Test
    public void testCreateDuplicateKeyException() {
        Asignar asignar = new Asignar();
        // Initialize asignar properties

        doThrow(DuplicateKeyException.class).when(jdbcTemplate).execute(anyString(), any(PreparedStatementCallback.class));

        try {
            asignarRepository.create(asignar);
        } catch (BadRequestException e) {
            // Expected exception
        }

        // Verify that the execute method was called with correct arguments
        verify(jdbcTemplate).execute(anyString(), any(PreparedStatementCallback.class));
    }

    @Test
    public void testShowAll() {
        List<Asignar> expectedAsignarList = new ArrayList<>();
        // Populate expectedAsignarList

        when(jdbcTemplate.query(anyString(), any(AsignarRowMapper.class))).thenReturn(expectedAsignarList);


    }

    // Add more test cases for other methods similarly

}
