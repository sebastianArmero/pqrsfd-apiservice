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
@ApiModel(value = "Formulario - Model", description = "Entidad para administrar los formularios de las encuestas")
public class Formulario {

	private static final long serialVersionUID = -8445943548965154778L;
	    
	@ApiModelProperty(notes = "Id del formulario")
	private int  formId;

	@ApiModelProperty(notes = "Nombre del Formulario")
	private String formNombre;
	
	@ApiModelProperty(notes = "Detalle del formulario")
	private String formDetalle;

	@ApiModelProperty(notes = "Formulario creado por")
	private String formCreadopor;
	
	@ApiModelProperty(notes = "Fecha creado Formulario")
	private Date  formFchcreado;
	
	@ApiModelProperty(notes = "Formulario modificado por")
	private String  formModificadopor;
	
	@ApiModelProperty(notes = "Fecha de modificado formulario")
	private Date  formFchmodificado;

	@ApiModelProperty(notes = "Estado del formulario")
	private Boolean  formEstado;
		
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   formProcesoauditoria;
	
}
