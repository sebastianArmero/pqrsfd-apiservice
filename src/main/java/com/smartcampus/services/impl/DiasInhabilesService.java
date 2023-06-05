package com.smartcampus.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IDiasInhabilesService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.models.DiasInhabilesDTO;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IDiasInhabilesRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class DiasInhabilesService implements IDiasInhabilesService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();
	public static final String MENSAJE = "los dias inhabiles no debe estar vacio";


	@Autowired
	private IDiasInhabilesRepository diasInhabilesRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(DiasInhabiles diasInhabiles) throws BadRequestException {

		if (diasInhabiles == null) {
			throw new BadRequestException(MENSAJE);
		}else
		 diasInhabilesRepository.create(diasInhabiles);
	}
	
	@Override
	public void createDias(List<DiasInhabiles>  diasInhabil) throws BadRequestException {

		if (diasInhabil == null) {
			throw new BadRequestException(MENSAJE);
		}else {
		for (DiasInhabiles diasInhabiles : diasInhabil) {
			 diasInhabilesRepository.create(diasInhabiles);
		}
		
		}
	}


	@Override
	public void update(Long id, DiasInhabiles r) {
	//coment
		if (r == null) {
			throw new BadRequestException(MENSAJE);
		}else
		 diasInhabilesRepository.update(id, r);
	
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<DiasInhabiles> showAll() {
		return diasInhabilesRepository.showAll();
	}

	@Override
	public DiasInhabiles showById(Long id) {
	//coment
		return null;
	}

	@Override
	public List<DiasInhabiles> showByIdDiin(Long id) {
	//coment
		return diasInhabilesRepository.showByIdDiin(id);
	}

	@Override
	public List<DiasInhabiles> showAllDiasInCons() {
	//coment
		return diasInhabilesRepository.showAllDiasInCons();
	}





	

}
