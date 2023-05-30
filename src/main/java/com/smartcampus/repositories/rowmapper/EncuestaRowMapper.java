package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asignar;
import com.smartcampus.models.Encuesta;
import com.smartcampus.models.TipoTipologia;


public class EncuestaRowMapper implements RowMapper<Encuesta> {

	@Override
	public Encuesta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		// stpq_pegeid_funcionario, stpq_tipo_estado_id, stpq_estado, stpq_pqrsdf_id
		return Encuesta.builder().encuId(rs.getLong("encu_id"))
				.requId(rs.getInt("requ_id"))
				.mediId(rs.getInt("medio_id"))
				.encuRealizadopor(rs.getString("encu_realizadopor"))
				.encuFchTramite(rs.getDate("encu_fch_tramite"))
				.encuProcesoauditoria(rs.getString("encu_procesoauditoria"))
				.encuRespValor(rs.getInt("encu_respvalor"))
				.encuRespDetalle(rs.getString("encu_respdetalle"))	
		    	.encuRespDetalle(rs.getString("encu_respdetalle"))
				.mediNombre(rs.getString("medi_nombre"))
				.realizadoPor(rs.getString("realizadopor"))
				.build();

	}

}
