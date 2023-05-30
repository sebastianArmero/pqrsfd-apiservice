package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class AsuntoService implements IAsuntoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IAsuntoRepository asuntoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Asunto asunto) throws BadRequestException {

		if (asunto == null) {
			throw new BadRequestException("El asunto no debe estar vacio");
		}else
		asuntoRepository.create(asunto);
	}

	@Override
	public void update(Long id, Asunto r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Asunto> showAll() {
		// TODO Auto-generated method stub
		return asuntoRepository.showAll();
	}

	@Override
	public Asunto showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
