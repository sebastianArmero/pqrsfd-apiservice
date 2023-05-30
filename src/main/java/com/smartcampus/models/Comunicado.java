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
@ApiModel(value = "Comunicado - Model", description = "Entidad para administrar los asuntos de los funcionarios")
public class Comunicado {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del comunicado")
	private Long  comuId;

	@ApiModelProperty(notes = "Requerimiento Id")
	private int requId;

	@ApiModelProperty(notes = "comunicado descripción")
	private String  comuDescripcion;

	@ApiModelProperty(notes = "comunicado fecha cambio")
	private Date  comuFechacambio;
	
	@ApiModelProperty(notes = "comunicado registrado por ")
	private String   comuRegistradopor;
	
	@ApiModelProperty(notes = "comunicado Revisado por ")
	private String   comuRevisadopor;
	
	@ApiModelProperty(notes = "comunicado estado")
	private String   comuEstado;
	
	@ApiModelProperty(notes = "comunicado fecha envio")
	private Date   comuFechaenviado;
	
	
	@ApiModelProperty(notes = "comunicado proceso auditoria")
	private String   comuProcesoauditoria;
	
	@ApiModelProperty(notes = "comunicado observación")
	private String   comuObservacion;
	
	@ApiModelProperty(notes = "Pege Id")
	private String   pegeId;
	
}
