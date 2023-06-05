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
import com.smartcampus.models.Normativa;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.INormativaRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.NormativaRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class NormativaJDBCRepositoryImpl implements INormativaRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Normativa r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_normativa(\r\n"
					+ "	norm_titulo, norm_descripcion, norm_creadopor)\r\n"
					+ "	VALUES (?, ?, ?);");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					//ps.setInt(1, r.getTipologiaId());
					ps.setString(1, r.getNormTitulo());
					ps.setString(2, r.getNormDescripcion());
					ps.setString(3, r.getNormCreadopor());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getNormId() + " ya existe");
		}

	}

	@Override
	public List<Normativa> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.normativa"));
		return jdbc.query(sql.toString(), new NormativaRowMapper());
	}

	@Override
	public void update(Long id, Normativa r) {
		//normativa
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//normativa
		
	}

	@Override
	public void delete(Long id) {
		//normativa
		
	}

	@Override
	public Normativa showById(Long id) {
		//normativa
		return null;
	}




}
