package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Medio;


public class MedioRowMapper implements RowMapper<Medio> {

	@Override
	public Medio mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Medio.builder().mediId(rs.getLong("medi_id"))
				.mediNombre(rs.getString("medi_nombre"))
				.mediRegistradopor(rs.getString("medi_registradopor"))
				.medFechacreado(rs.getDate("medi_fechacreado"))
				.mediModificadopor(rs.getString("medi_modificadopor"))
				.mediFechacambio(rs.getDate("medi_fechacambio"))
				.mediProcesoauditoria(rs.getString("medi_procesoauditoria"))
				.build();

	}

}
