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
@ApiModel(value = "PegeId - DTO", description = "Clase para enviar en las consultas el pegeid de un usuario.")
public class PegeIdDTO implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Codigo del usuario", required = true)
	@NotNull(message = "El PegeId no debe ser nula")
	private int pegeId;

	
}
