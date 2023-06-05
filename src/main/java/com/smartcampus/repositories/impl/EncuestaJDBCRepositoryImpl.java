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
import com.smartcampus.models.Encuesta;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IEncuestaRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.EncuestaRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class EncuestaJDBCRepositoryImpl implements IEncuestaRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Encuesta r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_encuesta(\r\n"
					+ "	requ_id, medio_id, encu_realizadopor,encu_procesoauditoria, encu_respvalor, encu_respdetalle)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					//ps.setInt(1, r.getTipologiaId());
					ps.setInt(1, r.getRequId());	
					ps.setInt(2, r.getMediId());
					ps.setString(3, r.getEncuRealizadopor());
					ps.setString(4, r.getEncuProcesoauditoria());
					ps.setInt(5, r.getEncuRespValor());
					ps.setString(6, r.getEncuRespDetalle());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getRequId() + " ya existe");
		}

	}

	@Override
	public List<Encuesta> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.encuesta"));
		return jdbc.query(sql.toString(), new EncuestaRowMapper());
	}

	@Override
	public void update(Long id, Encuesta r) {
		//Encuesta
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//Encuesta
		
	}

	@Override
	public void delete(Long id) {
		//Encuesta
		
	}

	@Override
	public Encuesta showById(Long id) {
		//Encuesta
		return null;
	}




}
