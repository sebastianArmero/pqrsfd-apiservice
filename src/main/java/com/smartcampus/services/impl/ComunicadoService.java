package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IComunicadoService;
import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Comunicado;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IComunicadoRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class ComunicadoService implements IComunicadoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private IComunicadoRepository comunicadoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Comunicado comunicado) throws BadRequestException {

		if (comunicado == null) {
			throw new BadRequestException("El asunto no debe estar vacio");
		}else
			comunicadoRepository.create(comunicado);
	}

	@Override
	public void update(Long id, Comunicado r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comunicado> showAll() {
		// TODO Auto-generated method stub
		return comunicadoRepository.showAll();
	}

	@Override
	public Comunicado showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comunicado> showByIdRequ(Long id) {
		// TODO Auto-generated method stub
		return comunicadoRepository.showByIdRequ(id);
		
	}


}
