package com.smartcampus.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.UnidadDTO;
import com.smartcampus.repositories.IUnidadRepository;
import com.smartcampus.repositories.rowmapper.UnidadRowMapper;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class UnidadJDBCRepositoryImpl implements IUnidadRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(UnidadDTO r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Long id, UnidadDTO r) {
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
	public List<UnidadDTO> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.unidad"));
		return jdbc.query(sql.toString(), new UnidadRowMapper());

	}

	@Override
	public UnidadDTO showById(Long id) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.unidadbyid"));
			return jdbc.queryForObject(sql.toString(), new Object[] { id }, new UnidadRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró la unidad con id=" + id);
		}

	}
}
