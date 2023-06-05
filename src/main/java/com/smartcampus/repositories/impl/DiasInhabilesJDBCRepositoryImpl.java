package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.repositories.IDiasInhabilesRepository;
import com.smartcampus.repositories.rowmapper.DiasInhabilesRowMapper;
import com.smartcampus.repositories.rowmapper.RequerimientoRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

import java.util.Date;


@Repository
public class  DiasInhabilesJDBCRepositoryImpl implements IDiasInhabilesRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(DiasInhabiles r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_diasinhabiles(diin_fecha,diin_registradopor, diin_procesoauditoria) VALUES (?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			    	ps.setDate(1, new java.sql.Date(((Date) r.getDiinFecha()).getTime()));
					ps.setString(2, r.getDiinRegistradopor());
					ps.setString(3, r.getDiinProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getDiinId() + " ya existe");
		}

	}

	@Override
	public List<DiasInhabiles> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.diasInhabilesT"));
		return jdbc.query(sql.toString(), new DiasInhabilesRowMapper());
	}

	@Override
	public void update(Long id, DiasInhabiles r) {
		
		StringBuilder sqlUpdate = new StringBuilder();
		sqlUpdate.append("UPDATE public.tb_diasinhabiles SET diin_estado=? WHERE diin_id= ?");
		jdbc.update(sqlUpdate.toString(),r.getDiinEstado(), id);
	
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//diasInhabiles
		
	}

	@Override
	public void delete(Long id) {
		//diasInhabiles
		
	}

	@Override
	public DiasInhabiles showById(Long id) {
		//diasInhabiles
		return null;
	}

	@Override
	public List<DiasInhabiles> showByIdDiin(Long id) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.ByIdDiasInhabiles"));
			return jdbc.query(sql.toString(), new Object[] { id }, new DiasInhabilesRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}

	@Override
	public List<DiasInhabiles> showAllDiasInCons() {
		//diasInhabiles
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.diasInhabilesConsul"));
		return jdbc.query(sql.toString(), new DiasInhabilesRowMapper());
	}



}
