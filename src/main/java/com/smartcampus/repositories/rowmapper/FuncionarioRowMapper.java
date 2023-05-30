package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Funcionario;

public class FuncionarioRowMapper implements RowMapper<Funcionario> {

	@Override
	public Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Funcionario.builder().unidId(rs.getLong("unid_id"))
				.unidNombre(rs.getString("unid_nombre"))
				.idfuncionario(rs.getInt("id_usuario"))
				.funcNombre(rs.getString("func_nombre"))
				.funcEmail(rs.getString("func_email"))
				.build();

	}

}
