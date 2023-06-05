package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IFuncionarioService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Funcionario;

import com.smartcampus.repositories.IFuncionarioRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class FuncionarioService implements IFuncionarioService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IFuncionarioRepository funcionarioRepository;

	@Autowired
	JwtTokenUtil jwtUtils;


	@Override
	public List<Funcionario> showAll() {
	//coment
		return funcionarioRepository.showAll();
	}

	@Override
	public Funcionario showById(Long id) {
	//coment
		return funcionarioRepository.showById(id);
	}
	
	@Override
	public List<Funcionario> showByIdFunc(Long id) {
	//coment
		return funcionarioRepository.showByIdFunc(id);
	}

	@Override
	public void create(Funcionario r) {
	//coment
		
	}

	@Override
	public void update(Long id, Funcionario r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}



}
