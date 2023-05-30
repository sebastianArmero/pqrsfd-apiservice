                                                                                                                                                                               package com.smartcampus.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartcampus.dto.SimpleObjectMessage;
import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.services.IAsignarService;
import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.Asignar;


import com.smartcampus.security.exceptions.NotFoundException;

@RestController
@RequestMapping(value = "/asignar/api")
@CrossOrigin
@Api(tags = "Asignar - Rest Controller", value = "Servicio para la controlar las asignaciones de las PQRSFD")
public class AsignarController {

	@Autowired
	private IAsignarService asignarService;

	public static final String URL_CONTROLLER = "/asignar/api";
	private static final String MENSAJE = "Objetos obtenidos con éxito";


	
	@ApiOperation(nickname = "showByIdFunc", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Asignar.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdFunc/{id}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdRequ(@PathVariable Long id) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), MENSAJE,
				asignarService.showByIdFunc(id)), HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "showByIdFuncHist", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Asignar.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdFuncHist/{idHist}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdFuncHist(@PathVariable Long idHist) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), MENSAJE,
				asignarService.showByIdFuncHistory(idHist)), HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "create", notes = "Este método permite crear un tipología de pqrsdf.", value = "Crear asignacion", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "asignación creado con exito"),
			@ApiResponse(code = 401, message = "la asignación no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@PostMapping(value = "/create")
	public ResponseEntity<SimpleObjectResponse> create(@RequestBody Asignar asignar) {
		try {
			asignarService.create(asignar);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "Asignación creada con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear la asignación",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}
	
	@ApiOperation(nickname = "delete", notes = "Este método permite borrar una asignación.", value = "Borrar asignacion", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "asignación borrada con exito"),
			@ApiResponse(code = 401, message = "la asignación no se pudo registrar", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<SimpleObjectResponse> delete(@PathVariable Long id) {
		try {
			asignarService.delete(id);
			return new ResponseEntity<>(
					new SimpleObjectResponse(HttpStatus.OK.value(), "Asignación borrada con éxito", null), HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(),
					"No es posible crear la asignación",
					new SimpleObjectMessage("ER-0003", ResponseType.INFO, LocationType.FACHADA, URL_CONTROLLER)),
					HttpStatus.NOT_FOUND);
		}

	}

	@ApiOperation(nickname = "showByIdRequ", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Asignar.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdRequ/{id}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdReque(@PathVariable Long id) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), MENSAJE,
				asignarService.showByIdRequ(id)), HttpStatus.OK);
	}
	
}
