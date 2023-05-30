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
@ApiModel(value = "Asunto - Model", description = "Entidad para administrar los asuntos de los funcionarios")
public class Asunto {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del asunto")
	private Long  asunId;

	@ApiModelProperty(notes = "Nombre del asunto")
	private String asunNombre;

	@ApiModelProperty(notes = "Fecha del cambio asunto")
	private Date  asunFechacambio;

	@ApiModelProperty(notes = "Asunto registrado por")
	private String  asunRegistradopor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   asunProcesoauditoria;
	
}
