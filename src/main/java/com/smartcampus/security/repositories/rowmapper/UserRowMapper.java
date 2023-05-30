package com.smartcampus.security.repositories.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.security.models.JwtUser;

public class UserRowMapper implements RowMapper<JwtUser> {

	@Override
	public JwtUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		JwtUser u = new JwtUser();
		u.setIdUsuario(rs.getLong("id_usuario"));
		u.setLogin(rs.getString("login"));
		u.setPassword(rs.getString("password"));
		u.setIdentificacion(rs.getString("identificacion"));
		u.setCorreoElectronico(rs.getString("correo_electronico"));
		u.setPegeId(rs.getInt("pege_id"));
		u.setEstado(rs.getString("estado"));
		u.setTokenAccess(rs.getString("token_acces"));
		u.setUsuaFechaCambio(null);
		u.setAuthorities(null);
		return u;
	}

}
