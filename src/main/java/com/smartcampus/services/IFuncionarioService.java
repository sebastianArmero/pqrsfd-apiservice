package com.smartcampus.services;

import java.util.List;

import com.smartcampus.models.Funcionario;

public interface IFuncionarioService extends IEntityService<Funcionario, Long> {
	public List<Funcionario> showByIdFunc(Long id);
}
