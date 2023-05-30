package com.smartcampus.repositories;

import java.util.List;

import com.smartcampus.models.Funcionario;

public interface IFuncionarioRepository extends IEntityRepository<Funcionario, Long> {
	public List<Funcionario> showByIdFunc(Long Id);	
}
