package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.PqrsfdAsun;
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdEst;
import com.smartcampus.models.PqrsfdRec;


public class PqrsfdEstRowMapper implements RowMapper<PqrsfdEst> {

	@Override
	public PqrsfdEst mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return PqrsfdEst.builder().requEstado(rs.getString("requ_estado"))
				.total(rs.getInt("total"))			
				.build();

	}

}
