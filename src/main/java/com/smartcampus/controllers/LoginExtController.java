package com.smartcampus.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.dto.SimpleObjectMessage;
import com.smartcampus.dto.SimpleObjectResponse;

import com.smartcampus.services.ILoginUserExtService;
import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.AuthenticateUserDTO;
import com.smartcampus.models.CrearUserExtDTO;
import com.smartcampus.models.PegeIdDTO;
import com.smartcampus.models.UserDTO;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.security.exceptions.NotFoundException;

@RestController
@RequestMapping(value = "/login/api")
@CrossOrigin
@Api(tags = "PQRSFD - Login Ext Rest Controller", value = "Servicio para la controlar la autenticación de los usuarios externos")
public class LoginExtController {

	@Autowired
	private ILoginUserExtService loginUserExtService;

	public static final String URL_CONTROLLER = "/login/api";

	

	@ApiOperation(nickname = "ValidateIdentificacion", notes = "Este método permite validar la identificacion del usuario externo para registrase y no este creada en la base de datos de Smart Campus.", value = "Validar Identificación", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Identificacion Usuario Externo registrado"),
			@ApiResponse(code = 401, message = "El usuario externo no esta registrado", response = SimpleObjectMessage.class),
			//@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado"),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class),
			@ApiResponse(code = 510, message = "El usuario no tiene correo electronico asociado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 511, message = "El usurio externo se encuentra deshabilitado", response = SimpleObjectMessage.class) })

	@PostMapping(value = "/validateidentificacion")

	
	public ResponseEntity<SimpleObjectResponse> validateIdentificacion(@RequestBody UserIdentificacionDTO identificacion) {
		try {
			SimpleObjectResponse simpleObjectResponse = loginUserExtService
					.validateIdentificacion(identificacion.getIdentificacion());
					return new ResponseEntity<>(new SimpleObjectResponse(simpleObjectResponse.getCodigo(),
					simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(404,
					"Documento no registrado", ""), HttpStatus.OK);

			
		}
	}

	
	@ApiOperation(nickname = "RegistroUsuarioExt", notes = "Este método permite registrar un usuario externo", value = "Registro Usuario Externo", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Creado con exito"),
			@ApiResponse(code = 401, message = "El usuario externo no se pudo registrar esta registrado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/registrarusuarioext")
	public ResponseEntity<SimpleObjectResponse> registrarusuarioext(@RequestBody CrearUserExtDTO usuarioExt) {
		try {
			loginUserExtService.create(usuarioExt);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "Usuario Externo creado con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear el usuario externo",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}

}
