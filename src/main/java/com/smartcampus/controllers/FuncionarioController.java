package com.smartcampus.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.smartcampus.services.IFuncionarioService;
import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
import com.smartcampus.models.Funcionario;
import com.smartcampus.security.exceptions.NotFoundException;

@RestController
@RequestMapping(value = "/funcionario/api")
@CrossOrigin
@Api(tags = "Funcionario Controller", value = "Servicio para la mostrar los funcionarios que responden las PQRSFD de la institución.")
public class FuncionarioController {

	@Autowired
	private IFuncionarioService iFuncionarioService;

	public static final String URL_CONTROLLER = "/funcionario/api";

	@ApiOperation(nickname = "showAll", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Funcionario.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showAll() {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito",
				iFuncionarioService.showAll()), HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "showByIdFunc", notes = "Este método obtiene los datos del usuario externo ", value = "Ver todos los objetos creados", response = SimpleObjectResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Valor de un objeto obtenido con éxito", response = Funcionario.class),
			@ApiResponse(code = 400, message = "Controla lo relacionado con errores con la base de datos, mal formación en la petición al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 401, message = "Acceso no autorizado, No ha iniciado sesión o token no válido", response = SimpleObjectMessage.class),
			@ApiResponse(code = 403, message = "El rol no tiene permisos para acceder al método", response = SimpleObjectMessage.class),
			@ApiResponse(code = 404, message = "No se encontró el recurso solicitado", response = SimpleObjectMessage.class),
			@ApiResponse(code = 500, message = "Error con la conexión a la base de datos", response = SimpleObjectMessage.class) })
	@GetMapping(value = "/showByIdFunc/{id}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<SimpleObjectResponse> showByIdFunc(@PathVariable Long id) {
		return new ResponseEntity<>(new SimpleObjectResponse(HttpStatus.OK.value(), "Objetos obtenidos con éxito",
				iFuncionarioService.showByIdFunc(id)), HttpStatus.OK);
	}

}
