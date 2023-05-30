package com.smartcampus.security.repositories.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.security.models.Authority;

public class AuthorityRowMapper implements RowMapper<Authority> {

	@Override
	public Authority mapRow(ResultSet rs, int rowNum) throws SQLException {
		Authority a = new Authority();
		a.setRolId(rs.getLong("rol_id"));
		a.setRolNombre(rs.getString("rol_nombre"));
		a.setRolDescripcion(rs.getString("rol_descripcion"));
		a.setRolTipo(rs.getString("rol_tipo"));
		a.setRolFechacambio(null);
		a.setRolRegistradopor(null);
		a.setRolEstado(rs.getString("rol_estado"));
		a.setRolPublico(rs.getString("rol_publico"));
		return a;
	}

}
