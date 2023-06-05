package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IEncuestaService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Encuesta;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IEncuestaRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class EncuestaService implements IEncuestaService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IEncuestaRepository encuestaRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Encuesta encuesta) throws BadRequestException {

		if (encuesta == null) {
			throw new BadRequestException("El asunto no debe estar vacio");
		}else
			encuestaRepository.create(encuesta);
	}



	@Override
	public List<Encuesta> showAll() {
	//coment
		return encuestaRepository.showAll();
	}



	@Override
	public void update(Long id, Encuesta r) {
	//coment
		
	}



	@Override
	public void delete(Long id) {
	//coment
		
	}



	@Override
	public Encuesta showById(Long id) {
	//coment
		return null;
	}

	


}
