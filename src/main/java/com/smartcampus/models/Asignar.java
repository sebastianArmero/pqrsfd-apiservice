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
@ApiModel(value = "Asignar - Model", description = "Entidad para administrar transacciones con asignar responsables")
public class Asignar {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id la Asignar")
	private int asigId;

	@ApiModelProperty(notes = "Id usuario funcionario")
	private int idUsuario;
	
	@ApiModelProperty(notes = "Id usuario funcionario")
	private String funcNombre;

	@ApiModelProperty(notes = "Id usuario funcionario")
	private String funcEmail;
	
	@ApiModelProperty(notes = "Id requerimiento")
	private int requId;

	@ApiModelProperty(notes = "Asignar creado pot")
	private String asigCreadoPor;
	
	@ApiModelProperty(notes = "Asignar fecha creado")
	private Date asigFechaCreado;
	
	@ApiModelProperty(notes = "fecha modificado ")
	private Date asigFechaModifica;
	
	
	
	@ApiModelProperty(notes = "modificado por ")
	private String asigModificadoPor;
	
	@ApiModelProperty(notes = "estado asignacion ")
	private String asigEstadoAsignacion;

	@ApiModelProperty(notes = "Observacion ")
	private String asigObservacion;

	@ApiModelProperty(notes = "Estado ")
	private boolean asigEstado;
	
	
	@ApiModelProperty(notes = "ciudad")
	private int ciudadId;
	
	@ApiModelProperty(notes = "ciudad nombre")
	private String ciudadNombre;
	
	@ApiModelProperty(notes = "Radicado ")
	private String requRadicado;
	
	@ApiModelProperty(notes = "fecha radicado ")
	private Date requFecharadicado;
	
	@ApiModelProperty(notes = "fecha radicado ")
	private Date requFechaterminorespuesta;
	
	@ApiModelProperty(notes = "Descripción ")
	private String requDescripcion;
	
	@ApiModelProperty(notes = "tire  id")
	private int tireId;
	
	@ApiModelProperty(notes = "titi nombre")
	private String titiNombre;
	
	@ApiModelProperty(notes = "Estado ")
	private String requEstado;
	

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
	private int reclasiTireId;
	
	@ApiModelProperty(notes = "Url")
	private String nombrereclasi;
	


	
}
