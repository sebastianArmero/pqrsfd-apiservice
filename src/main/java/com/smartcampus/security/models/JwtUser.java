package com.smartcampus.security.models;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1215456216545L;

	private Long idUsuario;
	private String login;
	private String password;
	private String identificacion;
	private String correoElectronico;
	private Integer pegeId;
	private String estado;
	private String tokenAccess;
	private Date usuaFechaCambio;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUser() {
		super();
		authorities = null;
	}

	@JsonIgnore
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return getUsername();
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@JsonIgnore
	public String getTokenAccess() {
		return tokenAccess;
	}

	public void setTokenAccess(String tokenAccess) {
		this.tokenAccess = tokenAccess;
	}

	@JsonIgnore
	public Date getUsuaFechaCambio() {
		return usuaFechaCambio;
	}

	public void setUsuaFechaCambio(Date usuaFechaCambio) {
		this.usuaFechaCambio = usuaFechaCambio;
	}

	@JsonIgnore
	public Integer getPegeId() {
		return pegeId;
	}

	public void setPegeId(Integer pegeId) {
		this.pegeId = pegeId;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
