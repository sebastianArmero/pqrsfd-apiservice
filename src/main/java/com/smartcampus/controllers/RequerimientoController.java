                                                                                                                                                                               package com.smartcampus.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
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
import com.smartcampus.services.IRequerimientoService;
import com.smartcampus.services.ITipoTipologiaService;


import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.Funcionario;
import com.smartcampus.models.Requerimiento;
import com.smartcampus.models.TipoTipologia;

import com.smartcampus.security.exceptions.NotFoundException;

@RestController
@RequestMapping(value = "/requerimiento/api")
@CrossOrigin
@Api(tags = "requerimiento - Rest Controller", value = "Servicio para la controlar los requerimiento de las PQRSFD")
@Component
public class RequerimientoController {

	@Autowired
	private IRequerimientoService requerimientoService;

	public static final String URL_CONTROLLER = "/requerimiento/api";
	private static final String MENSAJE = "Objetos obtenidos con éxito";
	private static final String MENSAJE_ERROR = "ER-0003";




	@ApiOperation(nickname = "showAll", notes = "Este método obtiene todos los requerimientos que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Requerimiento.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAll() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(),MENSAJE, requerimientoService.showAll()),
				HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "showAllAnonimo", notes = "Este método obtiene todos los requerimientos que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Requerimiento.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAllAnonimo", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAllAnonimo() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(),MENSAJE, requerimientoService.showAllAnonimo()),
				HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "showAllHist", notes = "Este método obtiene todos los requerimientos que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Requerimiento.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAllHist", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAllHist() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(),MENSAJE, requerimientoService.showAllHist()),
				HttpStatus.OK);
	}

	@ApiOperation(nickname = "create", notes = "Este método permite crear un tipología de pqrsdf.", value = "Crear requerimiento", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requerimiento creado con exito", response = Requerimiento.class),
			@ApiResponse(code = 401, message = "El tipología no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/create")
	public ResponseEntity<SimpleObjectResponse> create(@RequestBody Requerimiento requermiento) {
		try {
		
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "requerimiento creada con éxito", requerimientoService.createRequ(requermiento)), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear requerimiento",
					new SimpleObjectMessage(MENSAJE_ERROR, ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}
	@ApiOperation(nickname = "showByIdRequ", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Requerimiento.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdRequ/{id}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdRequ(@PathVariable Long id) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(),MENSAJE,
				requerimientoService.showByIdRequ(id)), HttpStatus.OK);
	}
	
	
	
	@ApiOperation(nickname = "showByIdentificacionAll", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Requerimiento.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdentificacionAll/{identificacion}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdentificacionAll(@PathVariable Long identificacion) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(),MENSAJE,
				requerimientoService.showByIdentificacionAll(identificacion)), HttpStatus.OK);
	}
	
	
	
	@ApiOperation(nickname = "showByIdentificacionHistory", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Requerimiento.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdentificacionHistory/{identificacion}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdentificacionHistory(@PathVariable Long identificacion) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(),MENSAJE,
				requerimientoService.showByIdentificacionHistory(identificacion)), HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "update", notes = "Este método permite actualizar los titulos docente general", value = "Actualizar los titulos docente general", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "dia inhabil actualizado con exito"),
			@ApiResponse(code = 401, message = "El dia inhabil no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<SimpleObjectResponse> update(@PathVariable("id") long id, @RequestBody Requerimiento requermiento) {
		try {
			requerimientoService.update(id, requermiento);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "los titulos docente general actualizado con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear los dias inhabiles",
					new SimpleObjectMessage(MENSAJE_ERROR, ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}
	

	@ApiOperation(nickname = "updateEstado", notes = "Este método permite actualizar los estados de la PQRSFD", value = "Actualizar los estados de la PQRSFD", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "dia inhabil actualizado con exito"),
			@ApiResponse(code = 401, message = "El dia inhabil no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PutMapping(value = "/updateEstado/{id}")
	public ResponseEntity<SimpleObjectResponse> updateEstado(@PathVariable("id") long id, @RequestBody Requerimiento requermiento) {
		try {
			requerimientoService.updateEstado(id, requermiento);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "El estados de la pqrsfd ha sido actualizado", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear el estado",
					new SimpleObjectMessage(MENSAJE_ERROR, ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}
	
	
	
}
