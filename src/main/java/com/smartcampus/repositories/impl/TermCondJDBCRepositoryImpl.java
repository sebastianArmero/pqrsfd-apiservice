package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.TermCond;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.repositories.ITermCondRepository;
import com.smartcampus.repositories.rowmapper.TermCondRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class TermCondJDBCRepositoryImpl implements ITermCondRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void createTermCond(UserIdentificacionDTO userIdentificacionDTO) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_termcond(teco_identificacion) VALUES (?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setString(1, userIdentificacionDTO.getIdentificacion());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + userIdentificacionDTO.getIdentificacion() + " ya existe");
		}

	}

	@Override
	public TermCond findTermCondByIdentificacion(String userIdentificacion) {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(this.env.getProperty("sql.termcond"));
			//sql.append("SELECT * from public.tb_termcond termcond where termcond.teco_identificacion=?");
			return jdbc.queryForObject(sql.toString(), new Object[] { userIdentificacion },	new TermCondRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(
					"No se encontró el usuario con identificación No.: " + userIdentificacion);
		}

	}

	@Override
	public void update(Long id, TermCond r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteWithUpdate(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TermCond> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TermCond showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(TermCond r) {
		// TODO Auto-generated method stub
		
	}

}
