                                                                                                                                                                               package com.smartcampus.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.dto.SimpleObjectMessage;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.models.Requerimiento;
import com.smartcampus.security.exceptions.NotFoundException;
import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.IPqrsfdCanService;
import com.smartcampus.services.IPqrsfdRecService;




@RestController
@RequestMapping(value = "/pqrsfdCan/api")
@CrossOrigin
@Api(tags = "PqrsfdCan - Rest Controller", value = "Servicio para la controlar los asuntos de las PQRSFD")
public class PqrsfdCanController {

	@Autowired
	private IPqrsfdCanService pqrsfdCanService;

	public static final String URL_CONTROLLER = "/pqrsfdCan/api";

	@ApiOperation(nickname = "showAll", notes = "Este método obtiene todos los asuntos que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = PqrsfdCan.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAll() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito", pqrsfdCanService.showAll()),
				HttpStatus.OK);
	}

	@ApiOperation(nickname = "showByAnio", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = PqrsfdCan.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByAnio", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByAnio(
			@RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio, 
		    @RequestParam("fechaFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFinal) 
			
	{
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito",
				pqrsfdCanService.showByAnio(fechaInicio, fechaFinal)), HttpStatus.OK);
	}
}
