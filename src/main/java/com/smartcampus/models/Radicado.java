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
@ApiModel(value = "Radicado - Model", description = "Entidad para administrar los radicados de las PQRSFD")
public class Radicado {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del radicado")
	private Long  radiId;

	@ApiModelProperty(notes = "Año del radicado")
	private int radiAnio;

	@ApiModelProperty(notes = "Numero del radicado")
	private int  radiNumero;

	@ApiModelProperty(notes = "Fecha cambio radicado")
	private Date  radiFechacambio;
	
	@ApiModelProperty(notes = "Registrado por")
	private String   radiRegistradopor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   radiProcesoauditoria;
	
}
