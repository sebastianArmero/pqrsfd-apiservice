package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IPreguntasFrecuentesService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.PreguntasFrecuente;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPreguntasFrecuentesRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class PreguntasFrecuentesService implements IPreguntasFrecuentesService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IPreguntasFrecuentesRepository preguntasFrecuentesRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(PreguntasFrecuente preguntasFrecuentes) throws BadRequestException {

		if (preguntasFrecuentes == null) {
			throw new BadRequestException("las preguntas frecuentes no debe estar vacio");
		}else
			preguntasFrecuentesRepository.create(preguntasFrecuentes);
	}

	@Override
	public void update(Long id, PreguntasFrecuente r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<PreguntasFrecuente> showAll() {
	//coment
		return preguntasFrecuentesRepository.showAll();
	}

	@Override
	public PreguntasFrecuente showById(Long id) {
	//coment
		return null;
	}


}
