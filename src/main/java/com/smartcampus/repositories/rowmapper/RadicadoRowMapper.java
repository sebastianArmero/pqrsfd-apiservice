package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Radicado;


public class RadicadoRowMapper implements RowMapper<Radicado> {

	@Override
	public Radicado mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Radicado.builder().radiId(rs.getLong("radi_id"))
				.radiAnio(rs.getInt("radi_anio"))
				.radiNumero(rs.getInt("radi_numero"))
				.radiFechacambio(rs.getDate("radi_fechacambio"))
				.radiRegistradopor(rs.getString("radi_registradopor"))
				.radiProcesoauditoria(rs.getString("radi_procesoauditoria"))
				.build();

	}

}
