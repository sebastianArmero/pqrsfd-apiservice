package com.smartcampus.repositories.impl;

import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.PqrsfdEst;

class PqrsfdEstJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PqrsfdEstJDBCRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testShowAll() {
        List<PqrsfdEst> expectedList = Arrays.asList(new PqrsfdEst(), new PqrsfdEst());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(expectedList);

      

        // Perform assertions on resultList to ensure expected behavior
        // ...
    }

    @Test
    void testShowByAnio() {
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 8, 31);
        List<PqrsfdEst> expectedList = Arrays.asList(new PqrsfdEst(), new PqrsfdEst());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(expectedList);

        List<PqrsfdEst> resultList = repository.showByAnio(fechaInicio, fechaFinal);

        // Perform assertions on resultList to ensure expected behavior
        // ...
    }
    @Test
    void testShowByAnioT() {
        LocalDate fechaInicio = LocalDate.of(2022, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2022, 7, 31);
        List<PqrsfdEst> expectedList = Arrays.asList(new PqrsfdEst(), new PqrsfdEst());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(expectedList);

        List<PqrsfdEst> resultList = repository.showByAnio(fechaInicio, fechaFinal);

        // Perform assertions on resultList to ensure expected behavior
        // ...
    }
    
    @Test
    void testShowByAnioE() {
        LocalDate fechaInicio = LocalDate.of(2022, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2022, 5, 29);
        List<PqrsfdEst> expectedList = Arrays.asList(new PqrsfdEst(), new PqrsfdEst());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(expectedList);

        List<PqrsfdEst> resultList = repository.showByAnio(fechaInicio, fechaFinal);

        // Perform assertions on resultList to ensure expected behavior
        // ...
    }
    // Add more test methods for other repository methods
}
