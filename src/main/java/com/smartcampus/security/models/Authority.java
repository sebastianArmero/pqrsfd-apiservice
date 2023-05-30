package com.smartcampus.security.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Raul A. Hernandez
 */
public class Authority implements Serializable {

	private static final long serialVersionUID = -999357542231488004L;
	private Long rolId;
	private String rolNombre;
	private String rolDescripcion;
	private String rolTipo;
	private Date rolFechacambio;
	private String rolRegistradopor;
	private String rolEstado;
	private String rolPublico;

	public Authority() {
		super();
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getRolDescripcion() {
		return rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public String getRolTipo() {
		return rolTipo;
	}

	public void setRolTipo(String rolTipo) {
		this.rolTipo = rolTipo;
	}

	public Date getRolFechacambio() {
		return rolFechacambio;
	}

	public void setRolFechacambio(Date rolFechacambio) {
		this.rolFechacambio = rolFechacambio;
	}

	public String getRolRegistradopor() {
		return rolRegistradopor;
	}

	public void setRolRegistradopor(String rolRegistradopor) {
		this.rolRegistradopor = rolRegistradopor;
	}

	public String getRolEstado() {
		return rolEstado;
	}

	public void setRolEstado(String rolEstado) {
		this.rolEstado = rolEstado;
	}

	public String getRolPublico() {
		return rolPublico;
	}

	public void setRolPublico(String rolPublico) {
		this.rolPublico = rolPublico;
	}

}