package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.PqrsfdAsun;
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdRec;


public class PqrsfdAsunRowMapper implements RowMapper<PqrsfdAsun> {

	@Override
	public PqrsfdAsun mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return PqrsfdAsun.builder().asunId(rs.getInt("asun_id"))
				.asunNombre(rs.getString("asun_nombre"))
				.total(rs.getInt("total"))			
				.build();

	}

}
