package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.smartcampus.models.TermCond;

public class TermCondRowMapper implements RowMapper<TermCond> {

	@Override
	public TermCond mapRow(ResultSet rs, int rowNum) throws SQLException {

		return TermCond.builder().terminoId(rs.getInt("termino_id")).tecoIdentificacion(rs.getString("teco_identificacion"))
				.tecoFchacepta(rs.getString("teco_fchacepta")).build();

	}

}
