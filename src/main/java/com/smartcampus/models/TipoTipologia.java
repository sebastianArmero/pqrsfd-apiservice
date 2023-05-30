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
@ApiModel(value = "TipoTipología - Model", description = "Entidad para administrar transacciones con las tipologías")
public class TipoTipologia {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id la tipología")
	private int titiId;

	@ApiModelProperty(notes = "nombre de la tipología")
	private String titiNombre;

	@ApiModelProperty(notes = "descripcion de la tipología")
	private String titiDescripcion;

	@ApiModelProperty(notes = "nomenclatura de dias de la tipología")
	private String titiNomenclatura;
	
	@ApiModelProperty(notes = "vencimiento de la tipología")
	private int titiVencimiento;
	
	@ApiModelProperty(notes = "fecha cambio por ")
	private Date titiFechacambio;
	
	@ApiModelProperty(notes = "registrado por ")
	private String titiRegistradopor;
	
	@ApiModelProperty(notes = "Porceso auditoria ")
	private String titiProcesoauditoria;

	
}
