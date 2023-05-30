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
@ApiModel(value = "Asunto - Model", description = "Entidad para administrar las preguntas frecuentes del aplicativo")
public class PreguntasFrecuente {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id de las preguntas frecuentes")
	private Long  prfrId;

	@ApiModelProperty(notes = "Nombre de las preguntas frecuentes")
	private String prfrNombre;

	@ApiModelProperty(notes = "descripcion de las preguntas frecuentes")
	private String  prfrDescripcion;

	@ApiModelProperty(notes = "Fecha creda")
	private Date  prfrFechacreado;
	
	@ApiModelProperty(notes = "Creado por")
	private String   prfrCreadopor;
	
	@ApiModelProperty(notes = "Estado Preguntas frecuentes")
	private Boolean   prfrEstado;
	
}
