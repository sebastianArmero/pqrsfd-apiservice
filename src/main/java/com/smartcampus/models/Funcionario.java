package com.smartcampus.models;

import java.util.Date;
import java.util.List;

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
@ApiModel(value = "Funcionario - Model", description = "Entidad para administrar los funcionarios")
public class Funcionario {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id del unidad")
	private Long unidId;

	@ApiModelProperty(notes = "Nombre de la unidad")
	private String unidNombre;

	@ApiModelProperty(notes = "id del funcionario")
	private int idfuncionario;
	
	@ApiModelProperty(notes = "Nombre funcionario")
	private String funcNombre;

	@ApiModelProperty(notes = "Email funcionario")
	private String  funcEmail;
	
}
