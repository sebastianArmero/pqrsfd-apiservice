                                                                                                                                                                               package com.smartcampus.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.dto.SimpleObjectMessage;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.services.IAsuntoService;
import com.smartcampus.services.ICargoService;
import com.smartcampus.services.IDiasInhabilesService;

import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.models.DiasInhabilesDTO;
import com.smartcampus.models.Requerimiento;
import com.smartcampus.security.exceptions.NotFoundException;

@RestController
@RequestMapping(value = "/diasInhabiles/api")
@CrossOrigin
@Api(tags = "DiasInhabiles - Rest Controller", value = "Servicio para la controlar los dias inhabiles de las PQRSFD")
public class DiasInhabilesController {

	@Autowired
	private IDiasInhabilesService diasInhabilesService;

	public static final String URL_CONTROLLER = "/diasInhabiles/api";
	private static final String MENSAJE = "Objetos obtenidos con éxito";


	@ApiOperation(nickname = "showAll", notes = "Este método obtiene todos los dias inhabiles que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = DiasInhabiles.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAll() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(), MENSAJE, diasInhabilesService.showAll()),
				HttpStatus.OK);
	}

	@ApiOperation(nickname = "create", notes = "Este método permite crear los dias inhabiles de pqrsdf.", value = "Crear dia inhabil", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "dia inhabil creado con exito"),
			@ApiResponse(code = 401, message = "El dia inhabil no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/create")
	public ResponseEntity<SimpleObjectResponse> createDias(@RequestBody List<DiasInhabiles> diasInhabiles) {
		try {
			diasInhabilesService.createDias(diasInhabiles);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "dias inhabiles creado con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear los dias inhabiles",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}
	
	@ApiOperation(nickname = "update", notes = "Este método permite actualizar los estados de los dias inhabiles de pqrsdf.", value = "Actualizar dia inhabil", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "dia inhabil actualizado con exito"),
			@ApiResponse(code = 401, message = "El dia inhabil no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<SimpleObjectResponse> update(@PathVariable("id") long id, @RequestBody DiasInhabiles diasInhabiles) {
		try {
			diasInhabilesService.update(id, diasInhabiles);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "dias inhabiles actualizado con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear los dias inhabiles",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}
	
	
	@ApiOperation(nickname = "showByIdDiin", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = DiasInhabiles.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdDiin/{id}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdDiin(@PathVariable Long id) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), MENSAJE,
				diasInhabilesService.showByIdDiin(id)), HttpStatus.OK);
	}
	
	
	@ApiOperation(nickname = "showAllDiasInCons", notes = "Este método obtiene  los dias habiles e inhabiles  que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = DiasInhabiles.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAllDiasInCons", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAllDiasInCons() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(), MENSAJE, diasInhabilesService.showAllDiasInCons()),
				HttpStatus.OK);
	}
	
	
	
	
}
