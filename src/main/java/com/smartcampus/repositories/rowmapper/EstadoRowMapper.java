package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.smartcampus.models.Estado;

public class EstadoRowMapper implements RowMapper<Estado> {

	@Override
	public Estado mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		// stpq_pegeid_funcionario, stpq_tipo_estado_id, stpq_estado, stpq_pqrsdf_id
		return Estado.builder().estadoId(rs.getInt("esta_estado_id"))
				.estadoNombre(rs.getString("esta_nombre"))
				.estadoDescripcion(rs.getString("esta_descripcion"))
				.build();

	}

}
