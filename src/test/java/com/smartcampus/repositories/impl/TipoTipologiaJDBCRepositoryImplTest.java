package com.smartcampus.repositories.impl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.TipoTipologia;

class TipoTipologiaJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private TipoTipologiaJDBCRepositoryImpl tipoTipologiaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        tipoTipologiaRepository = new TipoTipologiaJDBCRepositoryImpl(jdbcTemplate);
    }
    
    @MockBean
    private Environment env;

    @Test
    void testCreateTipoTipologia() {
        TipoTipologia tipoTipologia = new TipoTipologia();
        tipoTipologia.setTitiNombre("Nombre");
        tipoTipologia.setTitiDescripcion("Descripción");
        // ... Configura otros campos según sea necesario

        when(env.getProperty("sql.tipotipologia")).thenReturn("SELECT * FROM tb_tipotipologia"); // Mock para env.getProperty()

        tipoTipologiaRepository.create(tipoTipologia);
        // Aquí podrías realizar aserciones para verificar que el objeto se ha creado correctamente en la base de datos
    }
}
