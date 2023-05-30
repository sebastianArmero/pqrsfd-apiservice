package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Adjunto;
import com.smartcampus.models.Asunto;


public class AdjuntoRowMapper implements RowMapper<Adjunto> {

	@Override
	public Adjunto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Adjunto.builder().adjuId(rs.getLong("adju_id"))
				.requId(rs.getInt("requ_id"))	
				.adjuNombre(rs.getString("adju_nombre"))
				.adjFechaCambio(rs.getDate("adju_fechacambio"))
				.adjuRegistradoPor(rs.getString("adju_registradopor"))
				.adjProcesoAuditoria(rs.getString("adju_procesoauditoria"))
				.build();

	}

}
