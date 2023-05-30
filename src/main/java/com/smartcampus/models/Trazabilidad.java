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
@ApiModel(value = "Trazabilidad - Model", description = "Entidad para administrar la Trazabilidad")
public class Trazabilidad {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id de la Trazabilidad")
	private Long  trazId;

	@ApiModelProperty(notes = "Id requerimiento")
	private int requId;

	@ApiModelProperty(notes = "Id ejecutor usuario")
	private int  usuaIdejecutor;

	@ApiModelProperty(notes = "id usuario asignado")
	private int  usuaIdasignado;
	
	@ApiModelProperty(notes = " descripcion trazabilidad")
	private String   trazDescripcion;
	
	@ApiModelProperty(notes = "Fecha trazabilidad")
	private Date   trazFecha;
	
	@ApiModelProperty(notes = "Estado trazabilidad")
	private String   trazEstado;
	
	@ApiModelProperty(notes = "Fecha cambio trazabilidad")
	private Date   trazFechacambio;
	
	@ApiModelProperty(notes = "registrado por trazabilidad")
	private String   trazRegistradopor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   trazProcesoauditoria;
	
}
