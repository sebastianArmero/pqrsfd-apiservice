package com.smartcampus.repositories.impl;
import com.smartcampus.models.Requerimiento;
import com.smartcampus.repositories.IRequerimientoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class RequerimientoJDBCRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IRequerimientoRepository requerimientoRepository;

    @MockBean
    private Environment env; // Ajusta según tu configuración real

    @Test
    public void testCreateRequ() {
        Requerimiento requerimiento = new Requerimiento();
        requerimiento.setAsunId(1);
        requerimiento.setCiudadId(2);
        // Ajusta otros campos según tus datos

        when(env.getProperty("sql.requerimientomed")).thenReturn("SELECT * FROM tb_requerimiento"); // Mock para env.getProperty()

        requerimientoRepository.createRequ(requerimiento);

        // Verificar que jdbc.update fue llamado con el SQL correcto y los valores adecuados
        verify(jdbcTemplate).update(any(PreparedStatementCreator.class), any(KeyHolder.class));
    }

    @Test
    public void testCreateRequDuplicateKey() {
        Requerimiento requerimiento = new Requerimiento();
        requerimiento.setAsunId(1);
        requerimiento.setCiudadId(2);
        // Ajusta otros campos según tus datos

        when(env.getProperty("sql.requerimientomed")).thenReturn("SELECT * FROM tb_requerimiento"); // Mock para env.getProperty()
        when(jdbcTemplate.update(any(PreparedStatementCreator.class), any(KeyHolder.class)))
                .thenThrow(DuplicateKeyException.class); // Simula una excepción de duplicado

        // Aquí podrías realizar aserciones para verificar que se lanza la excepción esperada al crear un duplicado
    }
}
