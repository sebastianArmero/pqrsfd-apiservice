package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.smartcampus.models.EstadoPqrsdf;

public class EstadoPqrsdfRowMapper implements RowMapper<EstadoPqrsdf> {

	@Override
	public EstadoPqrsdf mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		// stpq_pegeid_funcionario, stpq_tipo_estado_id, stpq_estado, stpq_pqrsdf_id
		return EstadoPqrsdf.builder().estadoPqrsdfId(rs.getInt("stpq_estadopqrsdf_id"))
				.estadoPqrsdfFchEstado(rs.getDate("stpq_fechaestado"))
				.estadoPqrsdfPegeidFuncionario(rs.getInt("stpq_pegeid_funcionario"))
				.estadoPqrsdfEstado(rs.getBoolean("stpq_tipo_estado_id"))
				.estadoId(rs.getInt("stpq_estado"))
				.estadoPqrsdfId(rs.getInt("stpq_pqrsdf_id")).build();

	}

}
