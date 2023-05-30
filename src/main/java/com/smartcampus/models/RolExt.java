package com.smartcampus.models;

import javax.validation.constraints.NotNull;

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
@ApiModel(value = "Rol de usuario externo - Model", description = "Entidad para administrar transacciones con los roles de los Usuarios Externos")
public class RolExt {
	
	private static final long serialVersionUID = -8445943548965154778L;
	
	@ApiModelProperty(notes = "Id del rol", required = true)
	@NotNull(message = "El id no debe ser nulo")
    private int vRolId;
	@ApiModelProperty(notes = "Nombre del rol", required = true)
	@NotNull(message = "El nombre del rol no debe ser nulo")
    private String vRolNombre;
	@ApiModelProperty(notes = "Descripcion del rol", required = true)
	@NotNull(message = "La descripción del rol no debe ser nula")
    private String vRolDescripcion;
	@ApiModelProperty(notes = "Tipo de rol", required = true)
	@NotNull(message = "El tipo de rol no debe ser nulo")
    private String vRolTipo;
	@ApiModelProperty(notes = "Estado del rol", required = true)
	@NotNull(message = "El estado no debe ser nulo")
    private String vRolEstado;
	@ApiModelProperty(notes = "Rol publico o privado", required = true)
	@NotNull(message = "Valor del rol publico o privado")
    private String vRolPublico;
}
