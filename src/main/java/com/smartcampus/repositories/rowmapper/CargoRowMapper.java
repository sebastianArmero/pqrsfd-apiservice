package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.smartcampus.models.Cargo;

public class CargoRowMapper implements RowMapper<Cargo> {

	@Override
	public Cargo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Cargo.builder().cargId(rs.getLong("carg_id"))
				.cargNombre(rs.getString("carg_nombre"))
				.cargFechacambio(rs.getDate("carg_fechacambio"))
				.cargRegistradopor(rs.getString("carg_registradopor"))
				.cargProcesoauditoria(rs.getString("carg_procesoauditoria"))
				.build();

	}

}
