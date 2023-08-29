package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IRequerimientoService;
import com.smartcampus.services.ITipoTipologiaService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Funcionario;
import com.smartcampus.models.Requerimiento;
import com.smartcampus.models.TipoTipologia;
import com.smartcampus.repositories.IRequerimientoRepository;
import com.smartcampus.repositories.ITipoTipologiaRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
@Component
public class RequerimientoService implements IRequerimientoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IRequerimientoRepository requerimientoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Requerimiento requerimiento) throws BadRequestException {

		if (requerimiento == null) {
			throw new BadRequestException("El usuario externo no debe estar vacio");
		}else
			requerimientoRepository.create(requerimiento);
	}

	@Override
	public void update(Long id, Requerimiento r) {
		
		if (r == null) {
			throw new BadRequestException("los titulos docente general  no debe estar vacio");
		}else
			requerimientoRepository.update(id, r);
		
	}
		
	

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<Requerimiento> showAll() {
		return requerimientoRepository.showAll();

	}

	
	@Override
	public List<Requerimiento> showAllHist() {
		return requerimientoRepository.showAllHist();

	}

	@Override
	public List<Requerimiento> showByIdRequ(Long id) {
	//coment
		return requerimientoRepository.showByIdRequ(id);
	}

	@Override
	public Requerimiento showById(Long id) {
	//coment
		return null;
		
	}

	@Override
	public List<Requerimiento> showByIdentificacionAll(Long identificacion) {
	//coment
		return requerimientoRepository.showByIdentificacionAll(identificacion);
	}

	@Override
	public List<Requerimiento> showByIdentificacionHistory(Long identificacion) {
	//coment
		return requerimientoRepository.showByIdentificacionHistory(identificacion);
	}

	@Override
	public String createRequ(Requerimiento r) {
		
		return requerimientoRepository.createRequ(r);
		

	}

	@Override
	public List<Requerimiento> showAllAnonimo() {
	//coment
		return requerimientoRepository.showAllAnonimo();
	}

	@Override
	public void updateEstado(Long id, Requerimiento r) {
		if (r == null) {
			throw new BadRequestException("Los estados no debe estar vacio");
		}else
			requerimientoRepository.updateEstado(id, r);
		
	}

	@Override
	public List<Requerimiento> showAllAnonimoHist() {
		//coment
		return requerimientoRepository.showAllAnonimoHist();
	}

	





}
