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
@ApiModel(value = "Procceso - Model", description = "Entidad para administrar los procesos de las PQRSFD")
public class Proceso {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del proceso")
	private Long  procId;

	@ApiModelProperty(notes = "Id Padre")
	private int procIdpadre;

	@ApiModelProperty(notes = "Nombre del proceso")
	private String  procNombre;

	@ApiModelProperty(notes = "Descripcion proceso")
	private String  procDescripcion;
	
	@ApiModelProperty(notes = "Fecha cambio proceso")
	private Date   procFechacambio;
	
	@ApiModelProperty(notes = "Registrado por")
	private String   procRegistradopor;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   procProcesoauditoria;
}
