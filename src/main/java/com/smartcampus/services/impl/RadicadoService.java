package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IRadicadoService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Radicado;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IRadicadoRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class RadicadoService implements IRadicadoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IRadicadoRepository radicadoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Radicado radicado) throws BadRequestException {

		if (radicado == null) {
			throw new BadRequestException("El radicado no debe estar vacio");
		}else
		radicadoRepository.create(radicado);
	}

	@Override
	public void update(Long id, Radicado r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Radicado> showAll() {
		// TODO Auto-generated method stub
		return radicadoRepository.showAll();
	}

	@Override
	public Radicado showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
