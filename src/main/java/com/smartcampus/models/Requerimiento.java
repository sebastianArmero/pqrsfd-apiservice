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
@ApiModel(value = "Requerimiento - Model", description = "Entidad para administrar transacciones con las tipologías")
public class Requerimiento {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id requerimerto")
	private int requId;

	@ApiModelProperty(notes = "asunto requerimerto")
	private int asunId;

	@ApiModelProperty(notes = "ciudad")
	private int ciudadId;
	
	@ApiModelProperty(notes = "ciudad nombre")
	private String ciudadNombre;

	@ApiModelProperty(notes = "tire  id")
	private int tireId;
	
	@ApiModelProperty(notes = "titi nombre")
	private String titiNombre;
	
	@ApiModelProperty(notes = "titi vencimiento")
	private int titiVencimiento;
	
	@ApiModelProperty(notes = "page Id")
	private int pegeId;
	
	@ApiModelProperty(notes = "Medio recepción ")
	private int mediId;
	
	@ApiModelProperty(notes = "Medio recepción ")
	private String mediNombre;
	
	@ApiModelProperty(notes = "otra ciudad ")
	private String requOtraciudad;
	
	@ApiModelProperty(notes = "Radicado ")
	private String requRadicado;
	
	
	@ApiModelProperty(notes = "Descripción ")
	private String requDescripcion;

	
	@ApiModelProperty(notes = "Fecha termino respuesta  ")
	private Date requFechaterminorespuesta;

	
	@ApiModelProperty(notes = "reque fecha cambio ")
	private Date requFechacambio;

	
	@ApiModelProperty(notes = "registrado por  ")
	private String requRegistradopor;
	
	@ApiModelProperty(notes = "registrado por  ")
	private String requProcesoauditoria;
	
	@ApiModelProperty(notes = "Estado ")
	private String requEstado;
	
	@ApiModelProperty(notes = "fecha radicado ")
	private Date requFecharadicado;
	
	@ApiModelProperty(notes = "unidad territorial ")
	private int unidIdterritorial;
	
	@ApiModelProperty(notes = "Proc Id ")
	private int procId;
	
	@ApiModelProperty(notes = "Numero de documento")
	private int requNumDoc;

	@ApiModelProperty(notes = "Primer nombre")
	private String requPrimerNom;
	
	@ApiModelProperty(notes = "Segundo nombre")
	private String requSeguNom;
	
	@ApiModelProperty(notes = "Primer apellido")
	private String requPrimerApe;
	
	@ApiModelProperty(notes = "Segundo apellido")
	private String requSeguApe;
	
	@ApiModelProperty(notes = "Direccion")
	private String requDirec;
	
	@ApiModelProperty(notes = "Numero de telefono")
	private String requTel;
	
	@ApiModelProperty(notes = "Numero de telefono Opcional")
	private String requTelOp;
	
	
	@ApiModelProperty(notes = "Correo electronico ")
	private String requCorreo;
	
		
	
	@ApiModelProperty(notes = "Correo electonico opcional ")
	private String requEmailop;
	
	@ApiModelProperty(notes = "Url")
	private String requUrl;
	
	@ApiModelProperty(notes = "Url")
	private String requConsecutivoId;
	
	@ApiModelProperty(notes = "Url")
	private int reclasiTireId;
	
	@ApiModelProperty(notes = "Url")
	private String nombrereclasi;
	
	
	
	
	
	
	
	
	
}
