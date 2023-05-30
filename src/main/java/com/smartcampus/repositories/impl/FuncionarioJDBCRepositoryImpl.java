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

import com.smartcampus.models.Funcionario;
import com.smartcampus.repositories.IFuncionarioRepository;
import com.smartcampus.repositories.rowmapper.FuncionarioRowMapper;
import com.smartcampus.repositories.rowmapper.UsuarioExtRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class FuncionarioJDBCRepositoryImpl implements IFuncionarioRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public List<Funcionario> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.funcionarios"));
		return jdbc.query(sql.toString(), new FuncionarioRowMapper());
	}

	@Override
	public List<Funcionario> showByIdFunc(Long id) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.funcionariobyid"));
			return jdbc.query(sql.toString(), new Object[] { id }, new FuncionarioRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}

	@Override
	public void create(Funcionario r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Long id, Funcionario r) {
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
	public Funcionario showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
