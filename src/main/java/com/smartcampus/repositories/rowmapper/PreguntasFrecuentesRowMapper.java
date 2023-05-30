package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.PreguntasFrecuente;


public class PreguntasFrecuentesRowMapper implements RowMapper<PreguntasFrecuente> {

	@Override
	public PreguntasFrecuente mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return PreguntasFrecuente.builder().prfrId(rs.getLong("prfr_id"))
				.prfrNombre(rs.getString("prfr_nombre"))
				.prfrDescripcion(rs.getString("prfr_descripcion"))
				.prfrFechacreado(rs.getDate("prfr_fechacreado"))
				.prfrCreadopor(rs.getString("prfr_creadopor"))
				.prfrEstado(rs.getBoolean("prfr_estado"))
				.build();

	}

}
