package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdProm;
import com.smartcampus.models.PqrsfdRec;


public class PqrsfdPromRowMapper implements RowMapper<PqrsfdProm> {

	@Override
	public PqrsfdProm mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return PqrsfdProm.builder().diasDeDiferencia(rs.getInt("dias_de_diferencia"))
						
				.build();

	}

}
