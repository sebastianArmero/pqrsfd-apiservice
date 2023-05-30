package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.DiasInhabiles;


public class DiasInhabilesRowMapper implements RowMapper<DiasInhabiles> {

	@Override
	public DiasInhabiles mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return DiasInhabiles.builder().diinId(rs.getLong("diin_id"))
				.diinFecha(rs.getDate("diin_fecha"))
				.diinFechacambio(rs.getDate("diin_fechacambio"))
				.diinRegistradopor(rs.getString("diin_registradopor"))
				.diinProcesoauditoria(rs.getString("diin_procesoauditoria"))
				.diinEstado(rs.getBoolean("diin_estado"))
				.build();

	}

}
