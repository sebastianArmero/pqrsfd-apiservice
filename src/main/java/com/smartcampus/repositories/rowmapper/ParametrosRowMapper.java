package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Parametros;


public class ParametrosRowMapper implements RowMapper<Parametros> {

	@Override
	public Parametros mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Parametros.builder().paraId(rs.getLong("para_id"))
				.paraVencimiento(rs.getInt("para_vencimiento"))
				.paraAlertadias(rs.getInt("para_alertadias"))
				.paraRegistradpor(rs.getString("para_registradpor"))
				.paraFechacambio(rs.getDate("para_fechacambio"))
				.paraProcesoauditoria(rs.getString("para_procesoauditoria"))
				.build();

	}

}
