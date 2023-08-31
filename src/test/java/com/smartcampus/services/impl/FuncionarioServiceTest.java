package com.smartcampus.services.impl;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartcampus.models.Funcionario;
import com.smartcampus.repositories.IFuncionarioRepository;


class FuncionarioServiceTest {

    @Mock
    private IFuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testShowAll() {
        List<Funcionario> funcionarioList = new ArrayList<>();
        // Add Funcionario objects to funcionarioList

        when(funcionarioRepository.showAll()).thenReturn(funcionarioList);

        List<Funcionario> result = funcionarioService.showAll();

        verify(funcionarioRepository).showAll();
        // Perform assertions on the 'result' list
    }

    @Test
    void testShowById() {
        Long id = 1L;
        Funcionario funcionario = new Funcionario();
        // Set properties for funcionario

        when(funcionarioRepository.showById(id)).thenReturn(funcionario);

        Funcionario result = funcionarioService.showById(id);

        verify(funcionarioRepository).showById(id);
        // Perform assertions on the 'result' Funcionario object
    }

    @Test
    void testShowByIdFunc() {
        Long idFunc = 1L;
        List<Funcionario> funcionarioList = new ArrayList<>();
        // Add Funcionario objects to funcionarioList

        when(funcionarioRepository.showByIdFunc(idFunc)).thenReturn(funcionarioList);

        List<Funcionario> result = funcionarioService.showByIdFunc(idFunc);

        verify(funcionarioRepository).showByIdFunc(idFunc);
        // Perform assertions on the 'result' list
    }

    // You can add more test methods for other service methods

}
