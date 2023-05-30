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
@ApiModel(value = "Normativa - Model", description = "Entidad para administrar las normativas de las PQRSFD")
public class Normativa {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id de la normativa")
	private Long  normId;

	@ApiModelProperty(notes = "Nombre de la normativa")
	private String normTitulo;
	
	@ApiModelProperty(notes = "Descripcion de la normativa")
	private String  normDescripcion;
	
	@ApiModelProperty(notes = "Fecha creado de la normativa")
	private Date  normFechacreado;
	
	@ApiModelProperty(notes = "Creado por ")
	private String   normCreadopor;
	
}
