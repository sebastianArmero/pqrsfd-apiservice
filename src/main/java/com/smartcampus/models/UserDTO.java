package com.smartcampus.models;

import java.io.Serializable;

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
@ApiModel(value = "UserRequest - DTO", description = "Clase para enviar la consulta a la validación del usuario")
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Username/Login del usuario", required = true)
	@NotNull(message = "El id no debe ser nulo")
	private String username;

	
}
