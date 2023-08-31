package com.smartcampus.repositories.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Funcionario;
import com.smartcampus.repositories.rowmapper.FuncionarioRowMapper;

public class FuncionarioJDBCRepositoryTest {

    @Test
    public void testShowAllFuncionarios() {
        // Create a mock JdbcTemplate
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        
        // Create a mock RowMapper for Funcionario
        RowMapper<Funcionario> rowMapper = new FuncionarioRowMapper();
        
        // Create a list of mock Funcionario objects
        List<Funcionario> mockFuncionarios = new ArrayList<>();
        // Add mock Funcionario objects to the list
        
        // Set up the JdbcTemplate to return the mockFuncionarios list
        when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RowMapper.class))).thenReturn(mockFuncionarios);
        
        // Create an instance of FuncionarioJDBCRepositoryImpl and inject the mock JdbcTemplate
        FuncionarioJDBCRepositoryImpl funcionarioRepository = new FuncionarioJDBCRepositoryImpl();
     
    
        // Call the showAll method and verify the result
   
    }

    @Test
    public void testShowByIdFunc() {
        // Create a mock JdbcTemplate
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        
        // Create a mock RowMapper for Funcionario
        RowMapper<Funcionario> rowMapper = new FuncionarioRowMapper();
        
        // Create a mock Funcionario object
        Funcionario mockFuncionario = new Funcionario();
        // Set properties of the mockFuncionario
        
        // Set up the JdbcTemplate to return the mockFuncionario
        when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(Object[].class), Mockito.any(RowMapper.class))).thenReturn(mockFuncionario);
        
        // Create an instance of FuncionarioJDBCRepositoryImpl and inject the mock JdbcTemplate
        FuncionarioJDBCRepositoryImpl funcionarioRepository = new FuncionarioJDBCRepositoryImpl();

        
        // Call the showByIdFunc method and verify the result
    
    }
}
