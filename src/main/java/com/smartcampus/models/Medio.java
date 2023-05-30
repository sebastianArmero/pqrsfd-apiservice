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
@ApiModel(value = "Asunto - Model", description = "Entidad para administrar el medo de resepción")
public class Medio {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del medio")
	private Long  mediId;

	@ApiModelProperty(notes = "Nombre del medio")
	private String mediNombre;
	
	@ApiModelProperty(notes = "registrado por")
	private String  mediRegistradopor;


	@ApiModelProperty(notes = "Fecha de creado medio")
	private Date  medFechacreado;
	
	@ApiModelProperty(notes = "medio modificado por")
	private String   mediModificadopor;

	@ApiModelProperty(notes = "Fecha cambio del medio ")
	private Date  mediFechacambio;

	@ApiModelProperty(notes = "procesos de auditoria")
	private String  mediProcesoauditoria;


	

	
}
