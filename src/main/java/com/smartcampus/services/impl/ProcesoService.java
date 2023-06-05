package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IProcesoService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Proceso;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IProcesoRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class ProcesoService implements IProcesoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IProcesoRepository procesoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Proceso proceso) throws BadRequestException {

		if (proceso == null) {
			throw new BadRequestException("El proceso no debe estar vacio");
		}else
		procesoRepository.create(proceso);
	}

	@Override
	public void update(Long id, Proceso r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<Proceso> showAll() {
	//coment
		return procesoRepository.showAll();
	}

	@Override
	public Proceso showById(Long id) {
	//coment
		return null;
	}

}
