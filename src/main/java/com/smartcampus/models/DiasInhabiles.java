package com.smartcampus.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@ApiModel(value = "DiasInhabiles - Model", description = "Entidad para administrar los dias inhabiles para el proceso de los dias de respuesta de las PQRSFD")
public class DiasInhabiles {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del dia inhabil")
	private Long  diinId;

	@ApiModelProperty(notes = "Fechas de dias inhabiles")
	@JsonProperty("diinFecha")
	private Date diinFecha;

	@ApiModelProperty(notes = "Fecha del cambio dias inhabiles")
	private Date  diinFechacambio;

	@ApiModelProperty(notes = "Registrador por ")
	private String  diinRegistradopor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   diinProcesoauditoria;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private Boolean   diinEstado;
	
}
