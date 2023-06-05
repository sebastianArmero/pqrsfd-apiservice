package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.INormativaService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Normativa;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.INormativaRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class NormativaService implements INormativaService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private INormativaRepository normativaRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Normativa normativa) throws BadRequestException {

		if (normativa == null) {
			throw new BadRequestException("la normativa no debe estar vacio");
		}else
		normativaRepository.create(normativa);
	}

	@Override
	public void update(Long id, Normativa r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<Normativa> showAll() {
	//coment
		return normativaRepository.showAll();
	}

	@Override
	public Normativa showById(Long id) {
	//coment
		return null;
	}



}
