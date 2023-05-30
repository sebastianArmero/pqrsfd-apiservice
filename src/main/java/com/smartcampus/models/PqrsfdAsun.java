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
@ApiModel(value = "PqrsfdRec - Model", description = "Entidad para administrar los asuntos de los funcionarios")
public class PqrsfdAsun {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "tire  id")
	private int asunId;
	
	@ApiModelProperty(notes = "titi nombre")
	private String asunNombre; 
	
	@ApiModelProperty(notes = "titi nombre")
	private int total; 
	
	
}
