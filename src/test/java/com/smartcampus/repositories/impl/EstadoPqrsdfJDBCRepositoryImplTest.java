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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

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

    @Test
     void testCreateEstadoPqrsdf() {
        EstadoPqrsdf estadoPqrsdf = new EstadoPqrsdf();
        estadoPqrsdf.setPqrsdfId((long) 123); // Ajusta según tus datos

        when(env.getProperty("sql.estadoPqrsdf")).thenReturn("SELECT * FROM tb_estado_pqrsdf"); // Mock para env.getProperty()

        estadoPqrsdfRepository.create(estadoPqrsdf);
        // Aquí podrías realizar aserciones para verificar que el objeto se ha creado correctamente en la base de datos
    }
}