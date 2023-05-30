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
@ApiModel(value = "PqrsfdRec - Model", description = "Entidad para administrar los promedio de las pqrsfd contestadas")
public class PqrsfdProm {

	private static final long serialVersionUID = -8445943548965154778L;

	
	@ApiModelProperty(notes = "titi nombre")
	private int diasDeDiferencia; 
	
	
}
