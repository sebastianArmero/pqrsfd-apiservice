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
@ApiModel(value = "Asunto - Model", description = "Entidad para administrar las preguntas encuesta")
public class Preguntas {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "Id de las preguntas")
	private Long  pregId;

	@ApiModelProperty(notes = "Descripcion de las preguntas")
	private String pregDescripcion;

	@ApiModelProperty(notes = "Creado por")
	private String  pregCreadopor;

	@ApiModelProperty(notes = "Fecha creado preguntas")
	private Date  pregFechacreado;
	
	@ApiModelProperty(notes = "Modificado por")
	private String   pregModificadopor;
	
	@ApiModelProperty(notes = "Fecha modificado")
	private Date   pregFechamodifica;
	
	@ApiModelProperty(notes = "Proceso auditoria")
	private String   pregProcesoauditoria;
	
}
