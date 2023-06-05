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
import com.smartcampus.models.PreguntasFrecuente;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPreguntasFrecuentesRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.PreguntasFrecuentesRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PreguntasFrecuentesJDBCRepositoryImpl implements IPreguntasFrecuentesRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(PreguntasFrecuente r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_preguntasfrecuente(prfr_nombre, prfr_descripcion,prfr_creadopor, prfr_estado) VALUES (?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					
					ps.setString(1, r.getPrfrNombre());
					ps.setString(2, r.getPrfrDescripcion());
					ps.setString(3, r.getPrfrCreadopor());
					ps.setBoolean(4, r.getPrfrEstado());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getPrfrId() + " ya existe");
		}

	}

	@Override
	public List<PreguntasFrecuente> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.preguntasfrecuente"));
		return jdbc.query(sql.toString(), new PreguntasFrecuentesRowMapper());
	}

	@Override
	public void update(Long id, PreguntasFrecuente r) {
		//preguntas

		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//preguntas

		
	}

	@Override
	public void delete(Long id) {
		//preguntas

		
	}

	@Override
	public PreguntasFrecuente showById(Long id) {
		//preguntas

		return null;
	}




}
