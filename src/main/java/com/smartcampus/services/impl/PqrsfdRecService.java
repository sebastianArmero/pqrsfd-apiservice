package com.smartcampus.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IPqrsfdRecService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPqrsfdRecRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class PqrsfdRecService implements IPqrsfdRecService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IPqrsfdRecRepository pqrsfdRecRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(PqrsfdRec r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Long id, PqrsfdRec r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PqrsfdRec> showAll() {
		// TODO Auto-generated method stub
		return pqrsfdRecRepository.showAll();
	}

	@Override
	public PqrsfdRec showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PqrsfdRec> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
		return pqrsfdRecRepository.showByAnio(fechaInicio, fechaFinal);
	}




}
