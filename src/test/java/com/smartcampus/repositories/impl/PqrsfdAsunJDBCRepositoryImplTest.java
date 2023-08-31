package com.smartcampus.repositories.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.smartcampus.models.PqrsfdAsun;
import com.smartcampus.repositories.rowmapper.PqrsfdAsunRowMapper;

@ExtendWith(MockitoExtension.class)
public class PqrsfdAsunJDBCRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PqrsfdAsunJDBCRepositoryImpl repository;

    @Test
    public void testShowAll() {
        // Arrange
        List<PqrsfdAsun> expected = new ArrayList<>();
        expected.add(new PqrsfdAsun(/* ... */));
        expected.add(new PqrsfdAsun(/* ... */));
       
        // Act
        List<PqrsfdAsun> actual = repository.showAll();

        // Assert
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getAsunId(), actual.get(0).getAsunId());
        assertEquals(expected.get(1).getAsunId(), actual.get(1).getAsunId());
        // ...
    }
}
