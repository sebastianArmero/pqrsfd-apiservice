package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Glosario;


public class GlosarioRowMapper implements RowMapper<Glosario> {

	@Override
	public Glosario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Glosario.builder().glosId(rs.getLong("glos_id"))
				.glosNombre(rs.getString("glos_nombre"))
				.glosDescripcion(rs.getString("glos_descripcion"))
				.glosCreadopor(rs.getString("glos_creadopor"))
				.glosFechacreado(rs.getDate("glos_fechacreado"))
				.build();

	}

}
