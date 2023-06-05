package com.smartcampus.services.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartcampus.services.ILoginUserExtService;
import com.smartcampus.services.IPqrsdfService;

import javassist.bytecode.stackmap.TypeData.ClassName;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.EstadoPqrsdf;
import com.smartcampus.models.TermCond;
import com.smartcampus.models.PegeIdDTO;
import com.smartcampus.models.Pqrsdf;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.repositories.IEstadoPqrsdfRepository;
import com.smartcampus.repositories.ITermCondRepository;
import com.smartcampus.repositories.IPqrsdfRepository;
import com.smartcampus.repositories.IUsuarioExtRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class PqrsdfService implements IPqrsdfService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	
	private GenerateJson generateJson = new GenerateJson();
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IPqrsdfRepository pqrsdfRepository;

	@Autowired
	private ITermCondRepository termCondRepository;

	@Autowired
	private IEstadoPqrsdfRepository estadoPqrsdfRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(Pqrsdf pqrsdf) throws BadRequestException {

		if (pqrsdf == null) {
			throw new BadRequestException("La PQRSDF no debe estar vacia");
		}

		Long pqrsdfId = pqrsdfRepository.createPqrsdf(pqrsdf);

	

		if (pqrsdfId > 0) {
			//EstadoPqrsdf 
		}

	}

	@Override
	public void update(Long id, Pqrsdf r) {
	//coment

	}

	@Override
	public void delete(Long id) {
	//coment

	}

	@Override
	public List<Pqrsdf> showAll() {
		return pqrsdfRepository.showAll();

	}

	@Override
	public Pqrsdf showById(Long id) {
	//coment
		return null;
	}

	@Override
	public List<Pqrsdf> findByPegeId(PegeIdDTO pegeid) {

		return pqrsdfRepository.findByPegeId(pegeid);
	}

	@Override
	public List<Pqrsdf> findByIdentificacion(UserIdentificacionDTO identificacion) {

		return pqrsdfRepository.findByIdentificacion(identificacion);
	}

	@Override
	public TermCond findTermCondByIdentificacion(UserIdentificacionDTO userIdentificacion) {

		TermCond terminosUsuario = new TermCond();
		
		terminosUsuario = termCondRepository.findTermCondByIdentificacion(userIdentificacion.getIdentificacion());
		
		return terminosUsuario;
		
	}

	@Override
	public void aceptarTermCond(UserIdentificacionDTO userIdentificacionDTO) {
		if (userIdentificacionDTO == null) {
			throw new BadRequestException("Los terminos no pueden estar vacios");
		}else{
			termCondRepository.createTermCond(userIdentificacionDTO);

		}
	}

}
