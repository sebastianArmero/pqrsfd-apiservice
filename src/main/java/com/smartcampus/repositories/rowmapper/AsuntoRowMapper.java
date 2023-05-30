package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;


public class AsuntoRowMapper implements RowMapper<Asunto> {

	@Override
	public Asunto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Asunto.builder().asunId(rs.getLong("asun_id"))
				.asunNombre(rs.getString("asun_nombre"))
				.asunFechacambio(rs.getDate("asun_fechacambio"))
				.asunRegistradopor(rs.getString("asun_registradopor"))
				.asunProcesoauditoria(rs.getString("asun_procesoauditoria"))
				.build();

	}

}
