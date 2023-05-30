package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.TipoUnidad;


public class TipoUnidadRowMapper implements RowMapper<TipoUnidad> {

	@Override
	public TipoUnidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return TipoUnidad.builder().tiunId(rs.getLong("tiun_id"))
				.tiunNombre(rs.getString("tiun_nombre"))
				.tiunFechacambio(rs.getDate("tiun_fechacambio"))
				.tiunRegistradopor(rs.getString("tiun_registradopor"))
				.tiunProcesoauditoria(rs.getString("tiun_procesoauditoria"))
				.build();

	}

}
