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
import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.TipoUnidad;
import com.smartcampus.security.exceptions.NotFoundException;
import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ITipoUnidadService;




@RestController
@RequestMapping(value = "/tipoUnidad/api")
@CrossOrigin
@Api(tags = "Tipo unidad - Rest Controller", value = "Servicio para la controlar los asuntos de las PQRSFD")
public class TipoUnidadController {

	@Autowired
	private ITipoUnidadService tipounidadService;

	public static final String URL_CONTROLLER = "/tipoUnidad/api";

	@ApiOperation(nickname = "showAll", notes = "Este método obtiene todos los tipod de unidad  que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = TipoUnidad.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAll() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito", tipounidadService.showAll()),
				HttpStatus.OK);
	}

	@ApiOperation(nickname = "create", notes = "Este método permite crear un tipo de unidad de pqrsdf.", value = "Crear asunto", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "tipo de unidad creado con exito"),
			@ApiResponse(code = 401, message = "El tipo de unidad no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/create")
	public ResponseEntity<SimpleObjectResponse> create(@RequestBody TipoUnidad tipoUnidad) {
		try {
			tipounidadService.create(tipoUnidad);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "Tipo unidad creado con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear el tipo de unidad",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}

}
