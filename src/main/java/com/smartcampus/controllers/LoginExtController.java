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
	// @GetMapping(value = "/validateIdentificacion")
	@PostMapping(value = "/validateidentificacion")
	// public ResponseEntity<SimpleObjectResponse>
	// validateIdentificacion(@RequestParam (value="identificacion") String
	// identificacion) {
	public ResponseEntity<SimpleObjectResponse> validateIdentificacion(@RequestBody UserIdentificacionDTO identificacion) {
		try {
			SimpleObjectResponse simpleObjectResponse = loginUserExtService
					.validateIdentificacion(identificacion.getIdentificacion());
			System.out.println("simpleObjectResponse " + simpleObjectResponse.toString());
			return new ResponseEntity<>(new SimpleObjectResponse(simpleObjectResponse.getCodigo(),
					simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()), HttpStatus.OK);

		} catch (NotFoundException e) {
			SimpleObjectResponse simpleObjectResponse = new SimpleObjectResponse();
			System.out.println("Exception " + e);
			return new ResponseEntity<>(new SimpleObjectResponse(404,
					"Documento no registrado", ""), HttpStatus.OK);

			/*return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible realizar la validación",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);*/
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

	
	/*@ApiOperation(nickname = "Authentication", notes = "Este método permite validar el inicio de sesión", value = "Inicio de sesión", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Validado con exito"),
			@ApiResponse(code = 401, message = "Credenciales no son correctas", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/authentication")
	public ResponseEntity<SimpleObjectResponse> validateLogin(@RequestBody AuthenticateUserDTO obj) {
		// public ResponseEntity<SimpleObjectResponse> validateLogin(@RequestParam
		// (value="username") String username,@RequestParam (value="password") String
		// password) {

		try {
			SimpleObjectResponse simpleObjectResponse = loginUserExtService.authenticateUser(obj.getUsername(),
					obj.getPassword());
			return new ResponseEntity<>(new SimpleObjectResponse(simpleObjectResponse.getCodigo(),
					simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible realizar la validacion",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}
*/
	
	/*@ApiOperation(nickname = "ValidateUser", notes = "Este método permite validar si el usuario externo esta en Smart Campus.", value = "Validar Usuario Externo", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario Externo Valido"),
			@ApiResponse(code = 401, message = "El usuario no externo esta registrado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class),
			@ApiResponse(code = 510, message = "El usuario no tiene correo electronico asociado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 511, message = "El usurio externo se encuentra deshabilitado", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/validateUser")
	// public ResponseEntity<SimpleObjectResponse> validateUser(@RequestParam
	// (value="username") String username) {
	public ResponseEntity<SimpleObjectResponse> validateUser(@RequestBody UserDTO username) {
		try {
			SimpleObjectResponse simpleObjectResponse = loginUserExtService.validateUser(username.getUsername());
			System.out.println("simpleObjectResponse " + simpleObjectResponse.toString());
			return new ResponseEntity<>(new SimpleObjectResponse(simpleObjectResponse.getCodigo(),
					simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()), HttpStatus.OK);

		} catch (NotFoundException e) {
			System.out.println("Exception " + e);
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible realizar la validación",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}
	}*/
	
	
	
	/*
	 * @ApiOperation(nickname = "AuthenticationWithRememberSession", notes =
	 * "Este método permite validar el inicio de sesión", value =
	 * "Inicio de sesión", response = SimpleObjectResponse.class, produces =
	 * "application/json")
	 * 
	 * @ApiResponses(value = { @ApiResponse(code = 200, message =
	 * "Validado con exito"),
	 * 
	 * @ApiResponse(code = 401, message = "Credenciales no son correctas", response
	 * = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 404, message = "No se encontró el recurso solicitado",
	 * response = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 500, message =
	 * "Error con la conexión a la base de datos", response =
	 * SimpleObjectMessage.class) })
	 * 
	 * @PostMapping(value = "/authenticationwithRememberSession") public
	 * ResponseEntity<SimpleObjectResponse> authenticationwithRememberSession(
	 * 
	 * @RequestBody AuthenticateUserDTO obj) { try { SimpleObjectResponse
	 * simpleObjectResponse =
	 * loginUserExtService.authenticateUserRemember(obj.getLogin(),
	 * obj.getPassword(), obj.isRememberSession()); return new ResponseEntity<>(new
	 * SimpleObjectResponse(simpleObjectResponse.getCodigo(),
	 * simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()),
	 * HttpStatus.OK); } catch (NotFoundException e) { return new
	 * ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
	 * "No es posible realizar la validacion", new SimpleObjectMessage("ER-0003",
	 * ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * }
	 * 
	 * 
	 * @ApiOperation(nickname = "olvideClave", notes =
	 * "Este método permite recuperar la contraseña", value =
	 * "Recuperar contraseña", response = SimpleObjectResponse.class, produces =
	 * "application/json")
	 * 
	 * @ApiResponses(value = { @ApiResponse(code = 200, message =
	 * "Se ha enviado un mensaje al correo"),
	 * 
	 * @ApiResponse(code = 401, message = "El usuario no es correcto", response =
	 * SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 402, message =
	 * "No ha sido posible enviar el mensaje al correo registrado", response =
	 * SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 404, message = "No se encontró el recurso solicitado",
	 * response = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 500, message =
	 * "Error con la conexión a la base de datos", response =
	 * SimpleObjectMessage.class) })
	 * 
	 * @PostMapping(value = "/olvideClave") public
	 * ResponseEntity<SimpleObjectResponse> olvideClave(@RequestBody UserDTO
	 * userDTO) { try { SimpleObjectResponse simpleObjectResponse =
	 * loginUserExtService.olvideclave(userDTO.getUsername()); return new
	 * ResponseEntity<>(new SimpleObjectResponse(simpleObjectResponse.getCodigo(),
	 * simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()),
	 * HttpStatus.OK); } catch (NotFoundException e) { return new
	 * ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
	 * "No es posible realizar la recuperación", new SimpleObjectMessage("ER-0003",
	 * ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * }
	 * 
	 * @ApiOperation(nickname = "AuthenticateWithToken", notes =
	 * "Este método permite validar el inicio de sesión", value =
	 * "Inicio de sesión", response = SimpleObjectResponse.class, produces =
	 * "application/json")
	 * 
	 * @ApiResponses(value = { @ApiResponse(code = 200, message =
	 * "Validado con exito"),
	 * 
	 * @ApiResponse(code = 401, message = "Credenciales no son correctas", response
	 * = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 404, message = "No se encontró el recurso solicitado",
	 * response = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 500, message =
	 * "Error con la conexión a la base de datos", response =
	 * SimpleObjectMessage.class) })
	 * 
	 * @PostMapping(value = "/authenticationToken") public
	 * ResponseEntity<SimpleObjectResponse> authenticateWithToken(@RequestBody
	 * TokenDTO token) { try { SimpleObjectResponse simpleObjectResponse =
	 * loginUserExtService.authenticateToken(token.getToken()); return new
	 * ResponseEntity<>(new SimpleObjectResponse(simpleObjectResponse.getCodigo(),
	 * simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()),
	 * HttpStatus.OK); } catch (NotFoundException e) { return new
	 * ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
	 * "No es posible realizar la validacion", new SimpleObjectMessage("ER-0003",
	 * ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * }
	 * 
	 * @ApiOperation(nickname = "RefreshTokenUser", notes =
	 * "Este método permite refrescar el token", value = "Refrescar el token",
	 * response = SimpleObjectResponse.class, produces = "application/json")
	 * 
	 * @ApiResponses(value = { @ApiResponse(code = 200, message =
	 * "Actualizado con exito"),
	 * 
	 * @ApiResponse(code = 201, message = "El token no corresponde al usuario",
	 * response = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 202, message = "El token aún es válido", response =
	 * SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 401, message = "El token no es válido", response =
	 * SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 402, message = "El token no tiene formato correcto",
	 * response = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 404, message = "No se encontró el recurso solicitado",
	 * response = SimpleObjectMessage.class),
	 * 
	 * @ApiResponse(code = 500, message =
	 * "Error con la conexión a la base de datos", response =
	 * SimpleObjectMessage.class) })
	 * 
	 * @PostMapping(value = "/refreshTokenUser") public
	 * ResponseEntity<SimpleObjectResponse> refreshTokenUser(@RequestBody
	 * RefreshTokenUserDTO obj) { try { SimpleObjectResponse simpleObjectResponse =
	 * loginUserExtService.refreshTokenUser(obj.getLogin(), obj.getToken(),
	 * obj.isRememberSession()); return new ResponseEntity<>(new
	 * SimpleObjectResponse(simpleObjectResponse.getCodigo(),
	 * simpleObjectResponse.getMensaje(), simpleObjectResponse.getValor()),
	 * HttpStatus.OK); } catch (NotFoundException e) { return new
	 * ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
	 * "No es posible realizar la validacion", new SimpleObjectMessage("ER-0003",
	 * ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * }
	 */

}
