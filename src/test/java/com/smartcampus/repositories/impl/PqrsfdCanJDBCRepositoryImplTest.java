package com.smartcampus.repositories.impl;
import static org.mockito.Mockito.*;

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

import com.smartcampus.models.PqrsfdCan;

class PqrsfdCanJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PqrsfdCanJDBCRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testShowByAnioshowByAnio() {
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 8, 31);
        List<PqrsfdCan> expectedList = Arrays.asList(new PqrsfdCan(), new PqrsfdCan());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(expectedList);

        List<PqrsfdCan> resultList = repository.showByAnioshowByAnio(fechaInicio, fechaFinal);

        // Perform assertions on resultList to ensure expected behavior
        // ...
    }

    // Add more test methods for other repository methods
}
