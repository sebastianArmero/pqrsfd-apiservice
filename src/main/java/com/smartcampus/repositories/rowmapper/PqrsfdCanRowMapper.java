package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdRec;


public class PqrsfdCanRowMapper implements RowMapper<PqrsfdCan> {

	@Override
	public PqrsfdCan mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return PqrsfdCan.builder().mediId(rs.getInt("medi_id"))
				.mediNombre(rs.getString("medi_nombre"))
				.total(rs.getInt("total"))			
				.build();

	}

}
