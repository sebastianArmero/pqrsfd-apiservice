package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Comunicado;


public class ComunicadoRowMapper implements RowMapper<Comunicado> {

	@Override
	public Comunicado mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Comunicado.builder().comuId(rs.getLong("comu_id"))
				.requId(rs.getInt("requ_id"))
				.comuDescripcion(rs.getString("comu_descripcion"))
				.comuFechacambio(rs.getDate("comu_fechacambio"))
				.comuRegistradopor(rs.getString("comu_registradopor"))
				.comuRevisadopor(rs.getString("comu_revisadopor"))
				.comuEstado(rs.getString("comu_estado"))
				.comuFechaenviado(rs.getDate("comu_fechaenviado"))
				.comuProcesoauditoria(rs.getString("comu_procesoauditoria"))
				.comuObservacion(rs.getString("comu_observacion"))
				.pegeId(rs.getString("pege_id"))
		
				
				
				.build();

	}

}
