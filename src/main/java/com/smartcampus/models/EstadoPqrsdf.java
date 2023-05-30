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
@ApiModel(value = "Estado Pqrsdf - Model", description = "Entidad para administrar transacciones de los estados de las PQRSDF")
public class EstadoPqrsdf {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id de estado de la PQRSDF")
	private int estadoPqrsdfId;

	@ApiModelProperty(notes = "Fecha de estado de pqrsdf")
	private Date estadoPqrsdfFchEstado;

	@ApiModelProperty(notes = "Pegeid del funcionario", required = true)
	private Integer estadoPqrsdfPegeidFuncionario;

	@ApiModelProperty(notes = "Id del tipo de estado de la pqrsdf", required = true)
	private Integer estadoId;

	@ApiModelProperty(notes = "Estado del estado de la pqrsdf")
	private boolean estadoPqrsdfEstado;

	@ApiModelProperty(notes = "Id de la pqrsdf", required = true)
	private Long pqrsdfId;
	
}
