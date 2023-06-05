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
import com.smartcampus.models.Preguntas;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPreguntasRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.PreguntasRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PreguntasJDBCRepositoryImpl implements IPreguntasRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Preguntas r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_pregunta(preg_descripcion, preg_creadopor, preg_procesoauditoria)	VALUES (?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
				
					ps.setString(1, r.getPregDescripcion());
					ps.setString(2, r.getPregCreadopor());
					ps.setString(3, r.getPregProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getPregId() + " ya existe");
		}

	}

	public List<Preguntas> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.preguntas"));
		return jdbc.query(sql.toString(), new PreguntasRowMapper());
	}

	@Override
	public void update(Long id, Preguntas r) {
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
	public Preguntas showById(Long id) {
		//preguntas
		return null;
	}



}
