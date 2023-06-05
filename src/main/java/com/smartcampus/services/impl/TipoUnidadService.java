package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.ITipoUnidadService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.TipoUnidad;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.ITipoUnidadRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class TipoUnidadService implements ITipoUnidadService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private ITipoUnidadRepository tipoUnidadRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(TipoUnidad tipoUnidad) throws BadRequestException {

		if (tipoUnidad == null) {
			throw new BadRequestException("El tipo de unidad no debe estar vacio");
		}else
		tipoUnidadRepository.create(tipoUnidad);
	}

	@Override
	public void update(Long id, TipoUnidad r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<TipoUnidad> showAll() {
	//coment
		return tipoUnidadRepository.showAll();
	}

	@Override
	public TipoUnidad showById(Long id) {
	//coment
		return null;
	}


}
