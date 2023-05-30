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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.dto.SimpleObjectMessage;
import com.smartcampus.dto.SimpleObjectResponse;

import com.smartcampus.services.ILoginUserExtService;
import com.smartcampus.services.IPqrsdfService;
import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.AuthenticateUserDTO;
import com.smartcampus.models.PegeIdDTO;
import com.smartcampus.models.Pqrsdf;
import com.smartcampus.models.TermCond;
import com.smartcampus.models.UserDTO;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.security.exceptions.NotFoundException;

@RestController
@RequestMapping(value = "/pqrsdf/api")
@CrossOrigin
@Api(tags = "PQRSDF Rest Controller", value = "Servicio para la controlar las PQRSDF de la institución")
public class PqrsdfController {

	@Autowired
	private IPqrsdfService pqrsdfService;

	public static final String URL_CONTROLLER = "/pqrsdf/api";

	@ApiOperation(nickname = "showAll", notes = "Este método obtiene todas las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Pqrsdf.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAll() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito", pqrsdfService.showAll()),
				HttpStatus.OK);
	}

	@ApiOperation(nickname = "findByPegeId", notes = "Este método obtiene todas las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Pqrsdf.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/findByPegeId", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> findByPegeId(@RequestBody PegeIdDTO pegeid) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito",
				pqrsdfService.findByPegeId(pegeid)), HttpStatus.OK);
	}

	@ApiOperation(nickname = "findByIdentificacion", notes = "Este método obtiene todas las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Pqrsdf.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/findByIdentificacion", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> findByIdentificacion(
			@RequestBody UserIdentificacionDTO identificacion) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito",
				pqrsdfService.findByIdentificacion(identificacion)), HttpStatus.OK);
	}

	@ApiOperation(nickname = "crearpqrsdf", notes = "Este método permite crear una pqrsdf.", value = "Registro de PQRSDF", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "PQRSDF creada con exito"),
			@ApiResponse(code = 401, message = "La pqrsdf no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/crearpqrsdf")
	public ResponseEntity<SimpleObjectResponse> crearpqrs(@RequestBody Pqrsdf pqrsdf) {
		try {
			pqrsdfService.create(pqrsdf);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "Pqrsdf creada con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear la pqrsdf",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}

	@ApiOperation(nickname = "findByTermCondIdentificacion", notes = "Este método obtiene los termininos y condiciones", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = TermCond.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/findByTermCondIdentificacion", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> findTermCondByIdentificacion(
			@RequestBody UserIdentificacionDTO userIdentificacion) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito",
				pqrsdfService.findTermCondByIdentificacion(userIdentificacion)), HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "aceptarTerminos", notes = "Este método permite aceptar los terminos y condiciones de la App.", value = "Registro de Terminos y condiciones", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Terminos aceptados con exito", response = TermCond.class),
			@ApiResponse(code = 401, message = "No se aceptaron los terminos y condiciones", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/aceptarterminos")
	public ResponseEntity<SimpleObjectResponse> aceptarterminos(@RequestBody UserIdentificacionDTO userIdentificacion) {
		try {
			pqrsdfService.aceptarTermCond(userIdentificacion);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "Terminos aceptados con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible aceptar los terminos",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}

}
