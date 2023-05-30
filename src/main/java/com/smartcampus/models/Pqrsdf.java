package com.smartcampus.models;

import java.util.Date;
import java.util.List;

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
@ApiModel(value = "Pqrsdf - Model", description = "Entidad para administrar transacciones con las PQRSDF")
public class Pqrsdf {

	private static final long serialVersionUID = -8445943548965154778L;

	@ApiModelProperty(notes = "Id de la PQRSDF")
	private int pqrsdfId;

	@ApiModelProperty(notes = "Fecha de radicado de pqrsdf")
	private Date pqrsdfFchradicado;

	@ApiModelProperty(notes = "Fecha de max. de respuesta", required = true)
	private Date pqrsFchmaxresp;

	@ApiModelProperty(notes = "Id del funcionario que reporta la PQRSDF", required = true)
	private Integer pqrsPegeidreporta;

	@ApiModelProperty(notes = "Area del que reporta la PQRSDF")
	private Integer pqrsdfReportareaId;

	@ApiModelProperty(notes = "Estado del mensaje de la pqrsdf", required = true)
	private boolean pqrsEstamsj;

	@ApiModelProperty(notes = "Descripción de la PQRSDF")
	private String pqrsDetalle;

	@ApiModelProperty(notes = "Descripción de la respuesta de la PQRSDF")
	private String pqrsRespuesta;

	@ApiModelProperty(notes = "Fecha en que se da la respuesta al trámite")
	private Date pqrsFchrespuesta;

	@ApiModelProperty(notes = "Tipologia de la PQRSDF realizada por el usuario", required = true)
	private Integer pqrsTipologiaId;
	
	private String tipologiaNombre;

	@ApiModelProperty(notes = "Reclasificación de la PQRSDF por parte del administrador")
	private Integer pqrsReclasificacionId;

	private String reclasificaNombre;
	
	@ApiModelProperty(notes = "Tipo de recepción de la PQRSDF", required = true)
	private Integer pqrsTiporecepId;
	
	private String recepcionNombre;

	@ApiModelProperty(notes = "Id del stado de la PQRSDF", required = true)
	private Integer pqrsEstadoPqrsdfId;

	private String estadoNombre;
	
	@ApiModelProperty(notes = "PegeId del usuario que radica la PQRSDF", required = true)
	private Integer pqrsPegeidUsuario;

	@ApiModelProperty(notes = "Tipo de usuario que radica el tramite", required = true)
	private boolean pqrsUsuarioExt;
	
	private String pqrsIdentificacion;	

	static Long idPqrsdfUploadFile;

	public static Long  getIdPqrsdfUploadFile() {
		return idPqrsdfUploadFile;
	}

	public static void setPqrsdfUploadFile(Long idPqrsdfUploadFile) {
		Pqrsdf.idPqrsdfUploadFile = idPqrsdfUploadFile;
	}
	
/*
	public Pqrsdf(Integer pqrsPegeidreporta, Integer pqrsdfReportareaId, boolean pqrsEstamsj, String pqrsDetalle,
			Integer pqrsTipologiaId, Integer pqrsTiporecepId, Integer pqrsPegeidUsuario, boolean pqrsUsuarioExt) {
		super();
		this.pqrsPegeidreporta = pqrsPegeidreporta;
		this.pqrsdfReportareaId = pqrsdfReportareaId;
		this.pqrsEstamsj = pqrsEstamsj;
		this.pqrsDetalle = pqrsDetalle;
		this.pqrsTipologiaId = pqrsTipologiaId;
		this.pqrsTiporecepId = pqrsTiporecepId;
		this.pqrsPegeidUsuario = pqrsPegeidUsuario;
		this.pqrsUsuarioExt = pqrsUsuarioExt;
	}

	public Pqrsdf(Date pqrsdfFchradicado, Date pqrsFchmaxresp, Integer pqrsPegeidreporta, Integer pqrsdfReportareaId,
			boolean pqrsEstamsj, String pqrsDetalle, String pqrsRespuesta, Date pqrsFchrespuesta,
			Integer pqrsTipologiaId, Integer pqrsReclasificacionId, Integer pqrsTiporecepId, Integer pqrsEstadoPqrsdfId,
			Integer pqrsPegeidUsuario, boolean pqrsUsuarioExt) {
		super();
		this.pqrsdfFchradicado = pqrsdfFchradicado;
		this.pqrsFchmaxresp = pqrsFchmaxresp;
		this.pqrsPegeidreporta = pqrsPegeidreporta;
		this.pqrsdfReportareaId = pqrsdfReportareaId;
		this.pqrsEstamsj = pqrsEstamsj;
		this.pqrsDetalle = pqrsDetalle;
		this.pqrsRespuesta = pqrsRespuesta;
		this.pqrsFchrespuesta = pqrsFchrespuesta;
		this.pqrsTipologiaId = pqrsTipologiaId;
		this.pqrsReclasificacionId = pqrsReclasificacionId;
		this.pqrsTiporecepId = pqrsTiporecepId;
		this.pqrsEstadoPqrsdfId = pqrsEstadoPqrsdfId;
		this.pqrsPegeidUsuario = pqrsPegeidUsuario;
		this.pqrsUsuarioExt = pqrsUsuarioExt;
	}*/

	/*
	 * public Pqrsdf(@NotNull(message = "El Id no debe ser nulo debe ser nulo")
	 * Integer pqrsPegeidreporta,
	 * 
	 * @NotNull(message = "El estado no debe ser nulo") boolean pqrsEstamsj, String
	 * pqrsDetalle,
	 * 
	 * @NotNull(message = "La tipologia no debe ser nula") Integer pqrsTipologiaId,
	 * Integer pqrsReclasificacionId,
	 * 
	 * @NotNull(message = "El tipo de recepción no debe ser nulo") Integer
	 * pqrsTiporecepId,
	 * 
	 * @NotNull(message = "El pegeid no debe ser nulo") Integer pqrsPegeidUsuario,
	 * 
	 * @NotNull(message = "El tipo de usuario no debe ser nulo") boolean
	 * pqrsUsuarioExt) { super(); this.pqrsPegeidreporta = pqrsPegeidreporta;
	 * this.pqrsEstamsj = pqrsEstamsj; this.pqrsDetalle = pqrsDetalle;
	 * this.pqrsTipologiaId = pqrsTipologiaId; this.pqrsReclasificacionId =
	 * pqrsReclasificacionId; this.pqrsTiporecepId = pqrsTiporecepId;
	 * this.pqrsPegeidUsuario = pqrsPegeidUsuario; this.pqrsUsuarioExt =
	 * pqrsUsuarioExt; }
	 */
/*
	public Pqrsdf(Integer pqrsPegeidreporta, boolean pqrsEstamsj, String pqrsDetalle, Integer pqrsTipologiaId,
			Integer pqrsTiporecepId, Integer pqrsEstadoPqrsdfId, Integer pqrsPegeidUsuario, boolean pqrsUsuarioExt) {
		super();
		this.pqrsPegeidreporta = pqrsPegeidreporta;
		this.pqrsEstamsj = pqrsEstamsj;
		this.pqrsDetalle = pqrsDetalle;
		this.pqrsTipologiaId = pqrsTipologiaId;
		this.pqrsTiporecepId = pqrsTiporecepId;
		this.pqrsEstadoPqrsdfId = pqrsEstadoPqrsdfId;
		this.pqrsPegeidUsuario = pqrsPegeidUsuario;
		this.pqrsUsuarioExt = pqrsUsuarioExt;
	}

	public Pqrsdf(int pqrsdfId) {
		super();
		this.pqrsdfId = pqrsdfId;
	}

	*/
	
}
