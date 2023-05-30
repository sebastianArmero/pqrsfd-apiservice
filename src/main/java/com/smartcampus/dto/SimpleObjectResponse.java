package com.smartcampus.dto;

import com.smartcampus.models.UsuarioExt;

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
@ApiModel(value = "SimpleObjectResponse - Object Response", description = "Clase para estandarizar las respuestas del servidor")
public class SimpleObjectResponse {

	@ApiModelProperty(notes = "Código de respuesta", required = true)
	private Integer codigo;
	@ApiModelProperty(notes = "Mensaje de respuesta", required = true)
	private String mensaje;
	@ApiModelProperty(notes = "Contenido de la respuesta", required = true)
	private Object valor;
	
	public SimpleObjectResponse(Integer codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public SimpleObjectResponse(Integer codigo, String mensaje, Object valor) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.valor = valor;
	}

	public SimpleObjectResponse() {
		super();
	}
	
	
	
}
