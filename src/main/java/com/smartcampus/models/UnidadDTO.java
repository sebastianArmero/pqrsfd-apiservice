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
//@ApiModel(value = "Unidad - Model", description = "Entidad para administrar los asuntos de los funcionarios")
public class UnidadDTO {

	private static final long serialVersionUID = -8445943548965154778L;
	@ApiModelProperty(notes = "Id de la unidad")
	private Long unidId;
	
//	@ApiModelProperty(notes = "Nombre de la unidad")
	private String unidNombre;
	
//	@ApiModelProperty(notes = "Nombre funcionario")
	private String funcNombre;

//	@ApiModelProperty(notes = "Email funcionario")
	private String  funcEmail;
	

	
}
