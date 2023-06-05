package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IFormularioService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Formulario;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IFormularioRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class FormularioService implements IFormularioService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IFormularioRepository formularioRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Formulario formulario) throws BadRequestException {

		if (formulario == null) {
			throw new BadRequestException("El asunto no debe estar vacio");
		}else{
			formularioRepository.create(formulario);

		}
	}

	@Override
	public void update(Long id, Formulario r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<Formulario> showAll() {
	//coment
		return formularioRepository.showAll();
	}

	@Override
	public Formulario showById(Long id) {
	//coment
		return null;
	}



}
