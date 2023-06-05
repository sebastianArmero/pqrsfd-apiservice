package com.smartcampus.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IPqrsfdCanService;
import com.smartcampus.services.IPqrsfdRecService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPqrsfdCanRepository;
import com.smartcampus.repositories.IPqrsfdRecRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class PqrsfdCanService implements IPqrsfdCanService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IPqrsfdCanRepository pqrsfdCanRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(PqrsfdCan r) {
	//coment
		
	}

	@Override
	public void update(Long id, PqrsfdCan r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<PqrsfdCan> showAll() {
	//coment
		return pqrsfdCanRepository.showAll();
	}

	@Override
	public PqrsfdCan showById(Long id) {
	//coment
		return null;
	}

	@Override
	public List<PqrsfdCan> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal){
	//coment
		return pqrsfdCanRepository.showByAnioshowByAnio(fechaInicio, fechaFinal);
	}




}
