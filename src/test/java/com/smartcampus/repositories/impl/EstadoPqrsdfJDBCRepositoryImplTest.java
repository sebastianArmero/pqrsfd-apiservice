package com.smartcampus.repositories.impl;
import com.smartcampus.models.EstadoPqrsdf;
import com.smartcampus.repositories.IEstadoPqrsdfRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
 class EstadoPqrsdfJDBCRepositoryImplTest {
	

    @Mock
    private JdbcTemplate jdbcTemplate;

    private IEstadoPqrsdfRepository estadoPqrsdfRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estadoPqrsdfRepository = new EstadoPqrsdfJDBCRepositoryImpl();
    }
    
    @MockBean
    private Environment env;

    @SuppressWarnings("unchecked")
	@Test
    public void testCreateEstadoPqrsdf() {
        EstadoPqrsdf estadoPqrsdf = new EstadoPqrsdf();
        estadoPqrsdf.setPqrsdfId((long) 123); // Ajusta según tus datos

        when(env.getProperty("sql.estadoPqrsdf")).thenReturn("SELECT * FROM tb_estado_pqrsdf"); // Mock para env.getProperty()

        estadoPqrsdfRepository.create(estadoPqrsdf);

        // Verificar que jdbc.execute fue llamado con el SQL correcto y los valores adecuados
        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testCreateEstadoPqrsdfDuplicateKey() {
        EstadoPqrsdf estadoPqrsdf = new EstadoPqrsdf();
        estadoPqrsdf.setPqrsdfId((long) 123); // Ajusta según tus datos

        when(env.getProperty("sql.estadoPqrsdf")).thenReturn("SELECT * FROM tb_estado_pqrsdf"); // Mock para env.getProperty()
        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class)))
                .thenThrow(DuplicateKeyException.class); // Simula una excepción de duplicado

        // Aquí podrías realizar aserciones para verificar que se lanza la excepción esperada al crear un duplicado
    }
}

