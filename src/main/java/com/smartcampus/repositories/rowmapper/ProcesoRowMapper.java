package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Proceso;


public class ProcesoRowMapper implements RowMapper<Proceso> {

	@Override
	public Proceso mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Proceso.builder().procId(rs.getLong("proc_id"))
				.procIdpadre(rs.getInt("proc_idpadre"))
				.procNombre(rs.getString("proc_nombre"))
				.procDescripcion(rs.getString("proc_descripcion"))
				.procFechacambio(rs.getDate("proc_fechacambio"))
				.procRegistradopor(rs.getString("proc_registradopor"))
				.procProcesoauditoria(rs.getString("proc_procesoauditoria"))
				.build();

	}

}
