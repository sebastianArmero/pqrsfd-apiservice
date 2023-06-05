package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Formulario;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IFormularioRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.FormularioRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class FormularioJDBCRepositoryImpl implements IFormularioRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Formulario r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_formulario(\r\n"
					+ "form_nombre, form_detalle, form_creadopor, form_modificadopor, form_estado, form_procesoauditoria)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					//ps.setInt(1, r.getTipologiaId());
					ps.setString(1, r.getFormNombre());
					ps.setString(2, r.getFormDetalle());
					ps.setString(3, r.getFormCreadopor());
					ps.setString(4, r.getFormModificadopor());
					ps.setBoolean(5, r.getFormEstado());
					ps.setString(6, r.getFormProcesoauditoria());
					
					
					
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getFormId() + " ya existe");
		}

	}

	@Override
	public List<Formulario> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.formulario"));
		return jdbc.query(sql.toString(), new FormularioRowMapper());
	}

	@Override
	public void update(Long id, Formulario r) {
		//formulario
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//formulario
		
	}

	@Override
	public void delete(Long id) {
		//formulario
		
	}

	@Override
	public Formulario showById(Long id) {
		//formulario
		return null;
	}


}
