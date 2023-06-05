package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.ITrazabilidadService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Trazabilidad;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.ITrazabilidadRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class TrazabilidadService implements ITrazabilidadService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private ITrazabilidadRepository trazabilidadRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Trazabilidad trazabilidad) throws BadRequestException {

		if (trazabilidad == null) {
			throw new BadRequestException("La trazabilidad no debe estar vacio");
		}else
		  trazabilidadRepository.create(trazabilidad);
	}

	@Override
	public void update(Long id, Trazabilidad r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<Trazabilidad> showAll() {
	//coment
		return trazabilidadRepository.showAll();
	}

	@Override
	public Trazabilidad showById(Long id) {
	//coment
		return null;
	}

	@Override
	public List<Trazabilidad> showByIdRequ(Long id) {
	//coment
		return trazabilidadRepository.showByIdRequ(id);
	}



}
