package com.smartcampus.dto;

import com.smartcampus.dto.util.LocationType;
import com.smartcampus.dto.util.ResponseType;
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
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SimpleObjectMessage - Object Response", description = "Clase para estandarizar los errores del servidor")
public class SimpleObjectMessage {

	@ApiModelProperty(notes = "Código de respuesta", required = true)
	private String codigo;
	@ApiModelProperty(notes = "Tipo de respuesta", required = true)
	private ResponseType tipo;
	@ApiModelProperty(notes = "Descripción de la respuesta", required = true)
	private LocationType descripcion;
	@ApiModelProperty(notes = "Ubicación donde se generó la respuesta", required = true)
	private String ubicacion;

}
