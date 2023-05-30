package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Trazabilidad;


public class TrazabilidadRowMapper implements RowMapper<Trazabilidad> {

	@Override
	public Trazabilidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Trazabilidad.builder().trazId(rs.getLong("traz_id"))
				.requId(rs.getInt("requ_id"))
				.usuaIdejecutor(rs.getInt("usua_idejecutor"))
				.usuaIdasignado(rs.getInt("usua_idasignado"))
				.trazDescripcion(rs.getString("traz_descripcion"))
				
				.trazFecha(rs.getDate("traz_fecha"))
				.trazEstado(rs.getString("traz_estado"))
				.trazFechacambio(rs.getDate("traz_fechacambio"))
				.trazRegistradopor(rs.getString("traz_registradopor"))
				.trazProcesoauditoria(rs.getString("traz_procesoauditoria"))
				.build();

	}

}
