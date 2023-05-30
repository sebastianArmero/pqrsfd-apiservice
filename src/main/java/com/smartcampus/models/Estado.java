package com.smartcampus.models;

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
@ApiModel(value = "Estado - Model", description = "Entidad para administrar transacciones con los Estados")
public class Estado {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id del estado del estado")
	private int estadoId;

	@ApiModelProperty(notes = "Nombre del estado")
	private String estadoNombre;

	@ApiModelProperty(notes = "Descripción de estado")
	private String estadoDescripcion;

}
