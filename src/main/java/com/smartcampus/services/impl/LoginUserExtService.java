package com.smartcampus.services.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartcampus.services.ILoginUserExtService;

import javassist.bytecode.stackmap.TypeData.ClassName;

import com.smartcampus.commons.GenerateJson;
import com.smartcampus.security.JwtTokenUtil;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.CrearUserExtDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.repositories.IUsuarioExtRepository;
import com.smartcampus.security.exceptions.BadRequestException;

@Service
@Scope("singleton")
public class LoginUserExtService implements ILoginUserExtService {

	SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
	private GenerateJson generateJson = new GenerateJson();
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUsuarioExtRepository usuarioExtRepository;

	@Autowired
	JwtTokenUtil jwtUtils;

	@Override
	public SimpleObjectResponse validateUser(String username) {
	//coment
		if (username.isEmpty()) {
			throw new BadRequestException("El usuario no puede ser vacia");
		} else {
			UsuarioExt usuarioExt = new UsuarioExt();
			usuarioExt = usuarioExtRepository.findByLogin(username);
			if (usuarioExt.getIdentificacion().length() > 0) {
				simpleObjectResponse.setCodigo(200);
				simpleObjectResponse.setMensaje("Usuario válido");
				simpleObjectResponse.setValor("");
				
			} else {
				simpleObjectResponse.setCodigo(400);
				simpleObjectResponse.setMensaje("Usuario no Encontrado");
				simpleObjectResponse.setValor("");
			}
		}

		return simpleObjectResponse;

	}

	@Override
	public SimpleObjectResponse validateIdentificacion(String identificacion) {
		if (identificacion.isEmpty()) {
			throw new BadRequestException("La identificación no puede ser vacia");
		} else {
			UsuarioExt usuarioExt = new UsuarioExt();
			usuarioExt = usuarioExtRepository.findByIdentificacion(identificacion);
			
			
			if (usuarioExt.getIdentificacion().length() > 0) {
				simpleObjectResponse.setCodigo(200);
				simpleObjectResponse.setMensaje("Documento registrado");
				simpleObjectResponse.setValor("");
			}
			
			else {
				simpleObjectResponse.setCodigo(400);
				simpleObjectResponse.setMensaje("Documento no registrado.");
				simpleObjectResponse.setValor("");
			}
		}

		return simpleObjectResponse;

	}

	private UsuarioExt updatePass(UsuarioExt usuarioExt, String password) {
		byte[] decodedBytes = Base64.getDecoder().decode(password);
		String decodedString = new String(decodedBytes);
		
		String newPass = passwordEncoder.encode(decodedString);
		try {
			
			usuarioExt.setPasswordNew(newPass);
			
		} catch (Exception e) {
			if (e.getMessage().equals("401")) {
				simpleObjectResponse.setCodigo(401);
				simpleObjectResponse.setMensaje("No es correcto");
			} else {
				simpleObjectResponse.setCodigo(e.getCause().hashCode());
				simpleObjectResponse.setMensaje(e.getMessage());
			}
	
		}
		return usuarioExt;
	}

	@Override
	public SimpleObjectResponse authenticateUser(String usuario, String clave) {
		simpleObjectResponse = new SimpleObjectResponse();
		try {
			simpleObjectResponse.setCodigo(200);
			UsuarioExt usuarioExtAuth = usuarioExtRepository.findByLogin(usuario);
			simpleObjectResponse.setMensaje("Las credenciales son correctas");
			if (usuarioExtAuth.getPassword() == null) {
				usuarioExtAuth = updatePass(usuarioExtAuth, usuarioExtAuth.getLogin());
			}

			if (BCrypt.checkpw(clave, usuarioExtAuth.getPassword())) {

				simpleObjectResponse.setCodigo(201);
				simpleObjectResponse.setMensaje("Las credenciales son correctas");

	

				simpleObjectResponse.setValor(usuarioExtAuth);
			} else {
				simpleObjectResponse.setCodigo(401);
				simpleObjectResponse.setMensaje("Las credenciales no son correctas");
			}
		} catch (Exception e) {

			if (e.getMessage().equals("401")) {
				simpleObjectResponse.setCodigo(401);
				simpleObjectResponse.setMensaje("El usuario no es correcto");
			} else {
				simpleObjectResponse.setCodigo(e.getCause().hashCode());
				simpleObjectResponse.setMensaje(e.getMessage());
			}
		}
		return simpleObjectResponse;

	}

	@Override
	public void create(UsuarioExt usuarioExt) throws BadRequestException {
		if (usuarioExt == null) {
			throw new BadRequestException("El usuario externo no debe estar vacio");
		}
		usuarioExtRepository.create(usuarioExt);
	}

	@Override
	public SimpleObjectResponse authenticateUserRemember(String usuario, String clave, boolean rememberSession) {
	//coment
		return null;
	}

	@Override
	public SimpleObjectResponse olvideclave(String usuario) {
	//coment
		return null;
	}

	@Override
	public SimpleObjectResponse authenticateToken(String token) {
	//coment
		return null;
	}

	@Override
	public SimpleObjectResponse refreshTokenUser(String usuario, String token, boolean rememberSession) {
	//coment
		return null;
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
	public void create(CrearUserExtDTO userDto) {
		if (userDto == null) {
			throw new BadRequestException("El usuario externo no debe estar vacio");
		}
		usuarioExtRepository.createUserExt(userDto);
		
	}

}
