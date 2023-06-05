package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.ITipoTipologiaService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.TipoTipologia;

import com.smartcampus.repositories.ITipoTipologiaRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class TipoTipologiaService implements ITipoTipologiaService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private ITipoTipologiaRepository tipoTipologiaRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(TipoTipologia tipoTipologia) throws BadRequestException {

		if (tipoTipologia == null) {
			throw new BadRequestException("El usuario externo no debe estar vacio");
		}else
			tipoTipologiaRepository.create(tipoTipologia);
	}

	@Override
	public void update(Long id, TipoTipologia r) {
		
		if (r == null) {
			throw new BadRequestException("los titulos docente general  no debe estar vacio");
		}else
			tipoTipologiaRepository.update(id, r);
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<TipoTipologia> showAll() {
	//coment
		return tipoTipologiaRepository.showAll();
	}

	@Override
	public TipoTipologia showById(Long id) {
	//coment
		return null;
	}

	@Override
	public List<TipoTipologia> showByIdTiti(Long id) {
	//coment
		return tipoTipologiaRepository.showByIdTiti(id) ;
	}


}
