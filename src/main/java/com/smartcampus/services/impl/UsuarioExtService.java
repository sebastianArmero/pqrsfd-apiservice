package com.smartcampus.services.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartcampus.services.IUsuarioExtService;

import javassist.bytecode.stackmap.TypeData.ClassName;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.repositories.IUsuarioExtRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class UsuarioExtService implements IUsuarioExtService {

	@Autowired
	private IUsuarioExtRepository iUsuarioExtRepository;
	
	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	
	private GenerateJson generateJson = new GenerateJson();
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public void create(UsuarioExt r) {
	//coment
		
	}

	@Override
	public void update(Long id, UsuarioExt r) {
	//coment
		
	}

	@Override
	public void delete(Long id) {
	//coment
		
	}

	@Override
	public List<UsuarioExt> showAll() {
	//coment
		return null;
	}

	@Override
	public UsuarioExt showById(Long id) {
	//coment
		return null;
	}

	@Override
	public UsuarioExt findByIdentificacion(UserIdentificacionDTO identificacion) {
		
		return iUsuarioExtRepository.findByIdentificacion(identificacion.getIdentificacion());
	}

	public  SimpleObjectResponse validateByIdentificacion(UserIdentificacionDTO identificacion) {
	


		if(	(iUsuarioExtRepository.validateByIdentificacion(identificacion.getIdentificacion()))|| (iUsuarioExtRepository.validateByIdentificacionUserExt(Integer.parseInt(identificacion.getIdentificacion())))){
			simpleObjectResponse.setCodigo(200);
			simpleObjectResponse.setMensaje("Usuario  Encontrado");
			simpleObjectResponse.setValor("");
		}else {
			simpleObjectResponse.setCodigo(400);
			simpleObjectResponse.setMensaje("Usuario no Encontrado");
			simpleObjectResponse.setValor("");
		}
		
		return simpleObjectResponse;
	}

	
	

}
