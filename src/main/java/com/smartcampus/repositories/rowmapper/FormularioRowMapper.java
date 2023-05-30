package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Formulario;


public class FormularioRowMapper implements RowMapper<Formulario> {

	@Override
	public Formulario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	
		return Formulario.builder().formId(rs.getInt("form_id"))
				.formNombre(rs.getString("form_nombre"))
				.formDetalle(rs.getString("form_detalle"))
				.formCreadopor(rs.getString("form_creadopor"))
				.formFchcreado(rs.getDate("form_fchcreado"))
				.formModificadopor(rs.getString("form_modificadopor"))
				.formFchmodificado(rs.getDate("form_fchmodificado"))
				.formEstado(rs.getBoolean("form_estado"))
				.formProcesoauditoria(rs.getString("form_procesoauditoria"))
				.build();

	}

}
