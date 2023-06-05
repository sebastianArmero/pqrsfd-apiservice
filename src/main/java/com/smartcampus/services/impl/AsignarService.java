package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsignarService;
import com.smartcampus.services.ITipoTipologiaService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asignar;
import com.smartcampus.models.TipoTipologia;
import com.smartcampus.repositories.IAsignarRepository;
import com.smartcampus.repositories.ITipoTipologiaRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class AsignarService implements IAsignarService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IAsignarRepository asignarRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Asignar asignar) throws BadRequestException {

		if (asignar == null) {
			throw new BadRequestException("El usuario externo no debe estar vacio");
		}else
			asignarRepository.create(asignar);
	}

	@Override
	public void update(Asignar id, String requeEstado) {
		if (requeEstado == null ||  id.getRequId() < 0) {
			throw new BadRequestException("El usuario externo no debe estar vacio");
		}else
			asignarRepository.update(id, requeEstado);
	}
		
	

	@Override
	public void delete(Long id) {
	//coment
		asignarRepository.delete(id);
		
	}

	@Override
	public List<Asignar> showAll() {
	//coment
		return asignarRepository.showAll();
	}

	@Override
	public Asignar showById(Long id) {
	//coment
		return null;
	}

	@Override
	public List<Asignar> showByIdFunc(Long id) {
	//coment
		return asignarRepository.showByIdFunc(id);
	}

	@Override
	public List<Asignar> showByIdFuncHistory(Long idHist) {
		return asignarRepository.showByIdFuncHistory(idHist);
	}

	@Override
	public void update(Long id, Asignar r) {
	//coment
		
	}

	@Override
	public List<Asignar> showByIdRequ(Long id) {
	//coment
		return asignarRepository.showByIdRequ(id);
	}
	
}
