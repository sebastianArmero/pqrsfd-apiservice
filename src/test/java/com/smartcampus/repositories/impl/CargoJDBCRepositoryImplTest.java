package com.smartcampus.repositories.impl;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.smartcampus.models.Cargo;
import com.smartcampus.security.exceptions.BadRequestException;

@ExtendWith(MockitoExtension.class)
public class CargoJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CargoJDBCRepositoryImpl cargoRepository;

    @Test
    public void testCreateCargo_Success() {
        Cargo cargo = new Cargo();
        cargo.setCargNombre("Test Cargo");
        cargo.setCargFechacambio(new Date());
        cargo.setCargRegistradopor("Test User");
        cargo.setCargProcesoauditoria("Test Process");

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class))).thenReturn(true);

        cargoRepository.create(cargo);

        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
    }

    @Test
    public void testCreateCargo_DuplicateKeyException() {
        Cargo cargo = new Cargo();
        cargo.setCargNombre("Duplicate Cargo");
        cargo.setCargFechacambio(new Date());
        cargo.setCargRegistradopor("Test User");
        cargo.setCargProcesoauditoria("Test Process");

        when(jdbcTemplate.execute(any(String.class), any(PreparedStatementCallback.class)))
                .thenThrow(new DuplicateKeyException("Duplicate key"));

        try {
            cargoRepository.create(cargo);
        } catch (BadRequestException e) {
            // Exception should be thrown
        }

        verify(jdbcTemplate).execute(any(String.class), any(PreparedStatementCallback.class));
    }
}