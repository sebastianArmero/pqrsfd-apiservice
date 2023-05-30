package com.smartcampus.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.smartcampus.services.ICargoService;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.Cargo;

import com.smartcampus.repositories.ICargoRepository;

import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class CargoService implements ICargoService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();

	@Autowired
	private ICargoRepository cargoRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Cargo cargo) throws BadRequestException {

		if (cargo == null) {
			throw new BadRequestException("El cargo no debe estar vacio");
		}else
		cargoRepository.create(cargo);
	}

	@Override
	public void update(Long id, Cargo r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cargo> showAll() {
		return cargoRepository.showAll();
	}

	@Override
	public Cargo showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
