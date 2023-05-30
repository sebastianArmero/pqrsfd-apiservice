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
@ApiModel(value = "Adjunto - Model", description = "Entidad para administrar los Adjunto de las pqrsfd")
public class Adjunto {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del Adjunto")
	private Long  adjuId;

	@ApiModelProperty(notes = "Requerimiento")
	private int requId;

	@ApiModelProperty(notes = "Nombre Adjunto ")
	private String  adjuNombre;

	@ApiModelProperty(notes = "Fecha cambio Adjunto")
	private Date  adjFechaCambio;
	
	@ApiModelProperty(notes = "Registrado por")
	private String   adjuRegistradoPor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   adjProcesoAuditoria;
	
}
