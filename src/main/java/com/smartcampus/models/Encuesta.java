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
@ApiModel(value = "Encuesta - Model", description = "Entidad para administrar las encuesta")
public class Encuesta {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del asunto")
	private Long  encuId;

	@ApiModelProperty(notes = "Nombre del asunto")
	private int requId;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   requRadicado;
		
	
	@ApiModelProperty(notes = "Nombre del asunto")
	private int mediId;
	
	@ApiModelProperty(notes = "Asunto registrado por")
	private String  encuRealizadopor;

	@ApiModelProperty(notes = "Fecha del cambio asunto")
	private Date  encuFchTramite;

	@ApiModelProperty(notes = "Proceso auditoria")
	private String   encuProcesoauditoria;
	
	@ApiModelProperty(notes = "Nombre del asunto")
	private int encuRespValor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   encuRespDetalle;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   mediNombre;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   realizadoPor;
	
}
