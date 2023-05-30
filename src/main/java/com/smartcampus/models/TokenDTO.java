package com.smartcampus.models;

import java.io.Serializable;

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
@ApiModel(value = "Token - DTO", description = "Clase para enviar la consulta a la validación del usuario")
public class TokenDTO implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Token del usuario", required = true)
	private String token;

}
