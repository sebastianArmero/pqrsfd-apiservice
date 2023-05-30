package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IPreguntasService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Preguntas;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPreguntasRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class PreguntasService implements IPreguntasService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IPreguntasRepository preguntasRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Preguntas preguntas) throws BadRequestException {

		if (preguntas == null) {
			throw new BadRequestException("las preguntas no debe estar vacio");
		}else
			preguntasRepository.create(preguntas);
	}

	@Override
	public void update(Long id, Preguntas r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Preguntas> showAll() {
		// TODO Auto-generated method stub
		return preguntasRepository.showAll();
	}

	@Override
	public Preguntas showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
