package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Formulario;
import com.smartcampus.models.Normativa;


public class NormativaRowMapper implements RowMapper<Normativa> {

	@Override
	public Normativa mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Normativa.builder().normId(rs.getLong("norm_id"))
				.normTitulo(rs.getString("norm_titulo"))
				.normDescripcion(rs.getString("norm_descripcion"))
				.normFechacreado(rs.getDate("norm_fechacreado"))
				.normCreadopor(rs.getString("norm_creadopor"))
				.build();

	}

}
