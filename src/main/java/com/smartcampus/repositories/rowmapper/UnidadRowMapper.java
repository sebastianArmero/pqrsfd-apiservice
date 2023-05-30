package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.UnidadDTO;

public class UnidadRowMapper implements RowMapper<UnidadDTO> {

	@Override
	public UnidadDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		return UnidadDTO.builder()
				.unidId(rs.getLong("unid_id"))
				.funcNombre(rs.getString("unfc_nombre"))
				.funcEmail(rs.getString("unfc_email"))
				.unidNombre(rs.getString("unid_nombre")).build();

	}

}
