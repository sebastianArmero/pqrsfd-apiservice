package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.PqrsfdRec;


public class PqrsfdRecRowMapper implements RowMapper<PqrsfdRec> {

	@Override
	public PqrsfdRec mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return PqrsfdRec.builder().tireId(rs.getInt("tire_id"))
				.titiNombre(rs.getString("titi_nombre"))
				.total(rs.getInt("total"))			
				.build();

	}

}
