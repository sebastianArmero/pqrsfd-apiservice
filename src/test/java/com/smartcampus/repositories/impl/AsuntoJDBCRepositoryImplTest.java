package com.smartcampus.repositories.impl;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Asunto;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;


public class AsuntoJDBCRepositoryImplTest {

    @InjectMocks
    private AsuntoJDBCRepositoryImpl asuntoRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	@Test
    public void testCreate() {
        // Prepare test data
        Asunto asunto = new Asunto();
        // Set required properties

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.query(anyString(), any(AsuntoRowMapper.class))).thenReturn((List<Asunto>) asunto);

        // Call the method to test
        asuntoRepository.create(asunto);

        // Assertions can be added to ensure the method executed as expected
    }

    @Test
    public void testShowAll() {
        // Prepare test data
        List<Asunto> asuntos = new ArrayList<>();
        // Add test asuntos to the list

        // Mock the behavior of JdbcTemplate
        when(jdbcTemplate.query(anyString(), any(AsuntoRowMapper.class))).thenReturn(asuntos);

        // Call the method to test
        List<Asunto> result = asuntoRepository.showAll();

        // Assertions can be added to ensure the expected result
    }

    // Add more test methods for other repository methods
}
