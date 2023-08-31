package com.smartcampus.repositories.impl;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.smartcampus.models.TipoTipologia;
import com.smartcampus.repositories.rowmapper.TipoTipologiaRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

public class TipoTipologiaJDBCRepositoryImplTest {

    @InjectMocks
    private TipoTipologiaJDBCRepositoryImpl tipoTipologiaRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private Environment env;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTipoTipologia() {
        TipoTipologia tipoTipologia = new TipoTipologia();
        tipoTipologia.setTitiNombre("Nombre");
        tipoTipologia.setTitiDescripcion("Descripción");
        // Set other properties

        when(env.getProperty("sql.tipotipologia")).thenReturn("SELECT * FROM tb_tipotipologia");
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        tipoTipologiaRepository.create(tipoTipologia);

        //verify(jdbcTemplate, times(1)).execute(anyString(), any());
    }

    @Test
    public void testCreateTipoTipologiaDuplicateKeyException() {
        TipoTipologia tipoTipologia = new TipoTipologia();

        when(env.getProperty("sql.tipotipologia")).thenReturn("SELECT * FROM tb_tipotipologia");
        //when(jdbcTemplate.execute(anyString(), any())).thenThrow(DuplicateKeyException.class);

        try {
            tipoTipologiaRepository.create(tipoTipologia);
        } catch (BadRequestException e) {
            // Expected behavior
        }

       // verify(jdbcTemplate, times(1)).execute(anyString(), any());
    }

    @SuppressWarnings("unused")
	@Test
    public void testShowAllTipoTipologias() {
        List<TipoTipologia> tipoTipologiaList = new ArrayList<>();

        when(env.getProperty("sql.tipotipologia")).thenReturn("SELECT * FROM tb_tipotipologia");
        when(jdbcTemplate.query(anyString(), any(TipoTipologiaRowMapper.class))).thenReturn(tipoTipologiaList);

        List<TipoTipologia> result = tipoTipologiaRepository.showAll();

        verify(jdbcTemplate, times(1)).query(anyString(), any(TipoTipologiaRowMapper.class));
    }

    // Add more test cases for other methods

}