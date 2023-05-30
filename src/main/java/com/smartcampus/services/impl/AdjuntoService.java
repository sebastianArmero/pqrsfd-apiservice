package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAdjuntoService;
import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Adjunto;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.repositories.IAdjuntoRepository;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class AdjuntoService implements IAdjuntoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IAdjuntoRepository adjuntoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Adjunto adjunto) throws BadRequestException {

		if (adjunto == null) {
			throw new BadRequestException("El asunto no debe estar vacio");
		}else
			adjuntoRepository.create(adjunto);
	}

	@Override
	public void update(Long id, Adjunto r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Adjunto> showAll() {
		// TODO Auto-generated method stub
		return adjuntoRepository.showAll();
	}

	@Override
	public Adjunto showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAdjunto(List<Adjunto> adjunto) throws BadRequestException{
		if (adjunto == null) {
			throw new BadRequestException("los dias inhabiles no debe estar vacio");
		}else {
		for (Adjunto adjuntos : adjunto) {
			adjuntoRepository.create(adjuntos);
		}
		
		}
		
	}

	@Override
	public List<Adjunto> showByIdRequ(Long id) {
		// TODO Auto-generated method stub
		return adjuntoRepository.showByIdRequ(id);
	
	}


}
