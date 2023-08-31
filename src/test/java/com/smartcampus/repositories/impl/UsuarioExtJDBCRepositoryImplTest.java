package com.smartcampus.repositories.impl;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.smartcampus.models.CrearUserExtDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.repositories.rowmapper.UsuarioExtRowMapper;
import com.smartcampus.security.exceptions.NotFoundException;

public class UsuarioExtJDBCRepositoryImplTest {

    @InjectMocks
    private UsuarioExtJDBCRepositoryImpl usuarioExtRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private Environment env;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByIdentificacion() {
        UsuarioExt usuarioExt = new UsuarioExt();

        when(env.getProperty("sql.usuarioext")).thenReturn("SELECT * FROM sec_usuarioexterno WHERE identificacion=?");
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any(UsuarioExtRowMapper.class)))
                .thenReturn(usuarioExt);

        usuarioExtRepository.findByIdentificacion("identificacion");

       // verify(jdbcTemplate, times(1)).queryForObject(anyString(), any(Object[].class), any(UsuarioExtRowMapper.class));
    }

    @Test
    public void testFindByIdentificacionNotFound() {
        when(env.getProperty("sql.usuarioext")).thenReturn("SELECT * FROM sec_usuarioexterno WHERE identificacion=?");
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any(UsuarioExtRowMapper.class)))
                .thenThrow(EmptyResultDataAccessException.class);

        try {
            usuarioExtRepository.findByIdentificacion("identificacion");
        } catch (NotFoundException e) {
            // Expected behavior
        }

    //    verify(jdbcTemplate, times(1)).queryForObject(anyString(), any(Object[].class), any(UsuarioExtRowMapper.class));
    }

    // Add more test cases for other methods

}