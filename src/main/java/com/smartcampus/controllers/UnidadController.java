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
import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.Unidad;

import com.smartcampus.models.Unidad;
import com.smartcampus.security.exceptions.NotFoundException;
import com.smartcampus.services.IUnidadService;

@RestController
@RequestMapping(value = "/unidad/api")
@CrossOrigin
@Api(tags = "Unidad - Rest Controller", value = "Servicio para la controlar los asuntos de las Unidad")
public class UnidadController {

	@Autowired
	private IUnidadService iUnidadService;

	public static final String URL_CONTROLLER = "/unidad/api";

	@ApiOperation(nickname = "showAll", notes = "Este método obtiene todas las unidades que se manejan en las pqrsdf", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Unidad.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAll() {
		return new ResponseEntity<>(
				new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito", iUnidadService.showAll()),
				HttpStatus.OK);
	}

	@ApiOperation(nickname = "showById", notes = "Muestra el la unidad por el codigo.", value = "Mostrar unidad por codigo", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Unidad obtenida con éxito", response = Unidad.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "Rol no permitido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se	encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con	la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showById/{id}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showById(@PathVariable Long id) {
		return new ResponseEntity<>(
				new SimpleObjectResponse(Integer.valueOf(HttpStatus.OK.value()),
						"Unidad obtenida con éxito", iUnidadService.showById(id)),
				HttpStatus.OK);
	}
}
