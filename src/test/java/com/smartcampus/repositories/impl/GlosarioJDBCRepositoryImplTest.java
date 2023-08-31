package com.smartcampus.repositories.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Glosario;
import com.smartcampus.repositories.rowmapper.GlosarioRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

public class GlosarioJDBCRepositoryImplTest {

    private JdbcTemplate jdbcTemplate;
    private GlosarioJDBCRepositoryImpl glosarioRepository;

    @BeforeEach
    public void setup() {
        jdbcTemplate = mock(JdbcTemplate.class);
        glosarioRepository = new GlosarioJDBCRepositoryImpl(); // Inject JdbcTemplate through the constructor
    }
    @Test
    public void testCreateGlosario() throws SQLException {
        Glosario glosario = new Glosario();
        glosario.setGlosNombre("Test");
        glosario.setGlosDescripcion("Description");
        glosario.setGlosCreadopor("Creator");

        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<PreparedStatementCallback<Boolean>> callbackCaptor =
                ArgumentCaptor.forClass(PreparedStatementCallback.class);

        when(jdbcTemplate.execute(sqlCaptor.capture(), callbackCaptor.capture())).thenReturn(true);

        glosarioRepository.create(glosario);

        String capturedSql = sqlCaptor.getValue();
        assertEquals("INSERT INTO public.tb_glosario(glos_nombre, glos_descripcion, glos_creadopor) VALUES ( ?, ?, ?)", capturedSql);

        PreparedStatementCallback<Boolean> capturedCallback = callbackCaptor.getValue();
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.execute()).thenReturn(true);

        Boolean result = capturedCallback.doInPreparedStatement(preparedStatement);
        assertEquals(true, result);
    }

    @Test
    public void testCreateDuplicateGlosario() throws SQLException {
        Glosario glosario = new Glosario();
        glosario.setGlosNombre("Duplicate");
        glosario.setGlosDescripcion("Description");
        glosario.setGlosCreadopor("Creator");

        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<PreparedStatementCallback<Boolean>> callbackCaptor =
                ArgumentCaptor.forClass(PreparedStatementCallback.class);

        when(jdbcTemplate.execute(sqlCaptor.capture(), callbackCaptor.capture()))
                .thenThrow(new BadRequestException("Duplicate key"));

        try {
            glosarioRepository.create(glosario);
        } catch (BadRequestException e) {
            assertEquals("Duplicate key", e.getMessage());
        }

        String capturedSql = sqlCaptor.getValue();
        assertEquals("INSERT INTO public.tb_glosario(glos_nombre, glos_descripcion, glos_creadopor) VALUES ( ?, ?, ?)", capturedSql);
    }

    @Test
    public void testShowAll() { 
        List<Glosario> glosarios = new ArrayList<>();
        glosarios.add(new Glosario());
        when(jdbcTemplate.query(any(String.class), any(GlosarioRowMapper.class))).thenReturn(glosarios);

        List<Glosario> result = glosarioRepository.showAll();

        assertEquals(glosarios, result);
    }
}
