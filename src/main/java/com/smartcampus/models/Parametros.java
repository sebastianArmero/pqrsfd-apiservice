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
public class Parametros {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del parametrp")
	private Long  paraId;

	@ApiModelProperty(notes = "vencimiento del parametro")
	private int paraVencimiento;

	@ApiModelProperty(notes = "Alerta de los dias")
	private int  paraAlertadias;

	@ApiModelProperty(notes = "registrado por")
	private String  paraRegistradpor;
	
	@ApiModelProperty(notes = "Fecha cambio del parametro")
	private Date   paraFechacambio;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   paraProcesoauditoria;
	
}
