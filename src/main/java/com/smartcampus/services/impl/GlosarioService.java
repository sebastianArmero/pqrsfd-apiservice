package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IGlosarioService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Glosario;

import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IGlosarioRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class GlosarioService implements IGlosarioService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IGlosarioRepository glosarioRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Glosario glosario) throws BadRequestException {

		if (glosario == null) {
			throw new BadRequestException("El glosario no debe estar vacio");
		}else
			glosarioRepository.create(glosario);
	}

	@Override
	public void update(Long id, Glosario r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Glosario> showAll() {
		// TODO Auto-generated method stub
		return glosarioRepository.showAll();
	}

	@Override
	public Glosario showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}




}
