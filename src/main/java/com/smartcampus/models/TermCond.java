package com.smartcampus.models;

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
@ApiModel(value = "Terminos y condiciones - Model", description = "Entidad para administrar transacciones con los terminos y condiciones")
public class TermCond {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id de los terminos y condiciones")
	private int terminoId;

	@ApiModelProperty(notes = "Número de identificación del usuario")
	private String tecoIdentificacion;
	
	@ApiModelProperty(notes = "Fecha en que aceptó los terminos")
	private String tecoFchacepta;


}
