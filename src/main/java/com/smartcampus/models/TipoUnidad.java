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
@ApiModel(value = "TipoUnidad - Model", description = "Entidad para administrar los tipos de unidad")
public class TipoUnidad {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del tipo unidad")
	private Long  tiunId;

	@ApiModelProperty(notes = "Nombre del tipo de unidad")
	private String tiunNombre;

	@ApiModelProperty(notes = "Fecha del cambio tipo unidad")
	private Date  tiunFechacambio;

	@ApiModelProperty(notes = "tipo unidad registrado por")
	private String  tiunRegistradopor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   tiunProcesoauditoria;
	
}
