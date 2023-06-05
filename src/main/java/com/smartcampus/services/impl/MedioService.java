package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IMedioService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Medio;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IMedioRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class MedioService implements IMedioService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IMedioRepository medioRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Medio medio) throws BadRequestException {

		if (medio == null) {
			throw new BadRequestException("El medio no debe estar vacio");
		}else{
			medioRepository.create(medio);

		}
	}

	@Override
	public void update(Long id, Medio r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<Medio> showAll() {
	//coment
		return medioRepository.showAll();
	}

	@Override
	public Medio showById(Long id) {
	//coment
		return null;
	}



}
