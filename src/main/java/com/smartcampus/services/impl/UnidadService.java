package com.smartcampus.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IUnidadService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Unidad;
import com.smartcampus.models.UnidadDTO;

import com.smartcampus.repositories.IUnidadRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class UnidadService implements IUnidadService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IUnidadRepository unidadRepository;

	@Autowired
	JwtTokenUtil jwtUtils;



	@Override
	public Unidad showById(Long id) {
		UnidadDTO unidadDTO = unidadRepository.showById(id);

		Unidad unidad = new Unidad();
		
		unidad.setUnidId(unidadDTO.getUnidId());
		unidad.setUnidNombre(unidadDTO.getUnidNombre());
		unidad.setFuncNombre(unidadDTO.getFuncNombre());
		unidad.setFuncEmail(unidadDTO.getFuncEmail());

		return unidad;
	}



	@Override
	public void create(Unidad r) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update(Long id, Unidad r) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Unidad> showAll() {
		
		List<UnidadDTO> unidadesDTO = unidadRepository.showAll();
		List<Unidad> unidades = new ArrayList<Unidad>();
		
		
		for (UnidadDTO unidadDTO : unidadesDTO) {
			Unidad unidad = new Unidad();
			unidad.setUnidId(unidadDTO.getUnidId());
			unidad.setUnidNombre(unidadDTO.getUnidNombre());
			unidad.setFuncNombre(unidadDTO.getFuncNombre());
			unidad.setFuncEmail(unidadDTO.getFuncEmail());
			
			unidades.add(unidad);
		}
		
		
		
		return unidades;
		
		
	}

	
}
