package com.smartcampus.models;

import java.util.Date;

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
@ApiModel(value = "Cargo - Model", description = "Entidad para administrar los cargos de los funcionarios")
public class Cargo {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id del cargo")
	private Long cargId;

	@ApiModelProperty(notes = "Nombre del cargo")
	private String cargNombre;

	@ApiModelProperty(notes = "Fecha del cambio cargo")
	private Date  cargFechacambio;

	@ApiModelProperty(notes = "Cargo registrado por")
	private String  cargRegistradopor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   cargProcesoauditoria;
	
}
