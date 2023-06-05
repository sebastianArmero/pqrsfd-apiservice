package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IEstadoService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Estado;
import com.smartcampus.repositories.IEstadoRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class EstadoService implements IEstadoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();


	@Autowired
	private IEstadoRepository estadoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	
	@Override
	public void create(Estado estado) throws BadRequestException {
		
		if (estado == null) {
			throw new BadRequestException("El usuario externo no debe estar vacio");
		}
		estadoRepository.create(estado);
	}


	@Override
	public void update(Long id, Estado r) {
	//coment
		
	}


	@Override
	public void delete(Long id) {
	//coment
		
	}


	@Override
	public List<Estado> showAll() {
		return estadoRepository.showAll();
	}


	@Override
	public Estado showById(Long id) {
	//coment
		return null;
	}
	

}
