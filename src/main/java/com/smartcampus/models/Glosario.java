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
@ApiModel(value = "Glosario - Model", description = "Entidad para administrar el glosario de las PQRSFD")
public class Glosario {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id del glosario")
	private Long  glosId;

	@ApiModelProperty(notes = "Nombre del glosario")
	private String glosNombre;

	@ApiModelProperty(notes = "Descripcion del glosario")
	private String glosDescripcion;
	
	@ApiModelProperty(notes = "Creado por")
	private String  glosCreadopor;
	
	@ApiModelProperty(notes = "Fecha creado")
	private Date  glosFechacreado;



}
