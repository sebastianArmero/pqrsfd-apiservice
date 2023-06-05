package com.smartcampus.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Usuario externo - Model", description = "Entidad para administrar transacciones con Usuarios Externos")
public class UsuarioExt {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id del usuario", required = true)
	@NotNull(message = "El id no debe ser nulo")
	private int idUsuario;
	@ApiModelProperty(notes = "Tipo de documento del usuario", required = true)
	@NotNull(message = "El Tipo de documento no debe ser nulo")
	private String documentoTipo;
	@ApiModelProperty(notes = "Identificacion del usuario", required = true)
	@NotNull(message = "El identificacion no debe ser nulo")
	private String identificacion;
	@ApiModelProperty(notes = "Primer nombre del usuario", required = true)
	@NotNull(message = "El primer nombre debe ser nulo")
	private String primerNombre;
	@ApiModelProperty(notes = "Segundo nombre del usuario")
	private String segundoNombre;
	@ApiModelProperty(notes = "Primer apellido del usuario", required = true)
	@NotNull(message = "El primer apellido no debe ser nulo")
	private String primerApellido;
	@ApiModelProperty(notes = "Segundo apellido del usuario")
	private String segundoApellido;
	@ApiModelProperty(notes = "PegeId del usuario", required = true)
	@NotNull(message = "El pegeId no debe ser nulo")
	private int pegeId;
	@ApiModelProperty(notes = "Estado del usuario", required = true)
	@NotNull(message = "El Estado no debe ser nulo")
	private String estado;
	@ApiModelProperty(notes = "Dirección del usuario", required = true)
	@NotNull(message = "La dirección no debe ser nula")
	private String direccion;
	@ApiModelProperty(notes = "Ciudad de residencia del usuario", required = true)
	@NotNull(message = "La ciudad")
	private Integer ciudad;
	@ApiModelProperty(notes = "Teléfono del usuario", required = true)
	@NotNull(message = "El teléfono no debe ser nulo")
	private String telefono;
	@ApiModelProperty(notes = "Correo electronico del usuario", required = true)
	@NotNull(message = "El Correo electronico no debe ser nulo")
	private String correoElectronico;
	@ApiModelProperty(notes = "Correo opcional del usuario")
	private String correoOpcional;
	@ApiModelProperty(notes = "Numero celular del usuario")
	private String celular;
	@ApiModelProperty(notes = "Fecha de cambio en los datos del usuario")
	private String usuafechacambio;
	@ApiModelProperty(notes = "Login del usuario", required = true)
	@NotNull(message = "El login no debe ser nulo")
	private String login;
	@ApiModelProperty(notes = "Password nuevo del usuario")
	private String passwordNew;
	@ApiModelProperty(notes = "Token nuevo del usuario")
	private String tokenAccesNew;
	@ApiModelProperty(notes = "Password del usuario")
	private String password;
	@ApiModelProperty(notes = "Token del usuario")
	private String tokenAcces;
	@ApiModelProperty(notes = "Token del usuario")
	private List<RolExt> roles;
	
	
}
