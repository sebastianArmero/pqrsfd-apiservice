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
@ApiModel(value = "RefreshTokenUserDTO - DTO", description = "Clase para refrescar token")
public class RefreshTokenUserDTO implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Username/Login del usuario", required = true)
	private String login;
	@ApiModelProperty(notes = "Token del usuario", required = true)
	private String token;
	@ApiModelProperty(notes = "Recordar sesion")
	private boolean rememberSession;


}
