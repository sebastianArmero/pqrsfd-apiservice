package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IParametrosService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Parametros;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IParametrosRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class ParametrosService implements IParametrosService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IParametrosRepository parametrosRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Parametros parametros) throws BadRequestException {

		if (parametros == null) {
			throw new BadRequestException("El parametro no debe estar vacio");
		}else{
			parametrosRepository.create(parametros);
		}
		
	}

	@Override
	public void update(Long id, Parametros r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<Parametros> showAll() {
	//coment
		return parametrosRepository.showAll();
	}

	@Override
	public Parametros showById(Long id) {
	//coment
		return null;
	}



}
