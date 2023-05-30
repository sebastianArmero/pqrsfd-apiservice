package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Preguntas;


public class PreguntasRowMapper implements RowMapper<Preguntas> {

	@Override
	public Preguntas mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Preguntas.builder().pregId(rs.getLong("preg_id"))
				.pregDescripcion(rs.getString("preg_descripcion"))
				.pregCreadopor(rs.getString("preg_creadopor"))
				.pregFechacreado(rs.getDate("preg_fechacreado"))
				.pregModificadopor(rs.getString("preg_modificadopor"))
				.pregFechamodifica(rs.getDate("preg_fechamodifica"))
				.pregProcesoauditoria(rs.getString("preg_procesoauditoria"))
				.build();

	}

}
