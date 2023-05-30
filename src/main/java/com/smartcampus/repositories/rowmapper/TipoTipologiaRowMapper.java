package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.TipoTipologia;


public class TipoTipologiaRowMapper implements RowMapper<TipoTipologia> {

	@Override
	public TipoTipologia mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		// stpq_pegeid_funcionario, stpq_tipo_estado_id, stpq_estado, stpq_pqrsdf_id
		return TipoTipologia.builder().titiId(rs.getInt("titi_id"))
				.titiNombre(rs.getString("titi_nombre"))
				.titiDescripcion(rs.getString("titi_descripcion"))
				.titiNomenclatura(rs.getString("titi_nomenclatura"))
				.titiVencimiento(rs.getInt("titi_vencimiento"))
				.titiFechacambio(rs.getDate("titi_fechacambio"))
				.titiRegistradopor(rs.getString("titi_registradopor"))
				.titiProcesoauditoria(rs.getString("titi_procesoauditoria"))
				.build();

	}

}
