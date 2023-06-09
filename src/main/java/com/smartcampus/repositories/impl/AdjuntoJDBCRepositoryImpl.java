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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.Adjunto;
import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.repositories.IAdjuntoRepository;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.rowmapper.AdjuntoRowMapper;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.DiasInhabilesRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class AdjuntoJDBCRepositoryImpl implements IAdjuntoRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Adjunto r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_adjunto(requ_id, adju_nombre,adju_registradopor, adju_procesoauditoria) VALUES (?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					
					ps.setInt(1, r.getRequId());
					ps.setString(2, r.getAdjuNombre());
					ps.setString(3, r.getAdjuRegistradoPor());
					ps.setString(4, r.getAdjProcesoAuditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getAdjuId() + " ya existe");
		}

	}

	@Override
	public List<Adjunto> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.adjunto"));
		return jdbc.query(sql.toString(), new AdjuntoRowMapper());
	}

	@Override
	public void update(Long id, Adjunto r) {
		//update
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		// deleteWithUpdate
		
	}

	@Override
	public void delete(Long id) {
		// delete
		
	}

	@Override
	public Adjunto showById(Long id) {
		
		return null;
	}

	@Override
	public List<Adjunto> showByIdRequ(Long id) {
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.adjuntoByRequ"));
			return jdbc.query(sql.toString(), new Object[] { id }, new AdjuntoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}





}
