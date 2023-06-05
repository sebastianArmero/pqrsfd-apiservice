package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.Estado;
import com.smartcampus.repositories.IEstadoRepository;

import com.smartcampus.repositories.rowmapper.EstadoRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class EstadoJDBCRepositoryImpl implements IEstadoRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Estado r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_estado(esta_estado_id, esta_nombre, esta_descripcion)	VALUES (?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1, r.getEstadoId());
					ps.setString(2, r.getEstadoNombre());
					ps.setString(3, r.getEstadoDescripcion());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getEstadoId() + " ya existe");
		}

	}

	@Override
	public List<Estado> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.estados"));
		return jdbc.query(sql.toString(), new EstadoRowMapper());
	}

	@Override
	public void update(Long id, Estado r) {
		//Estado
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//Estado
		
	}

	@Override
	public void delete(Long id) {
		//Estado
		
	}

	@Override
	public Estado showById(Long id) {
		//Estado
		return null;
	}

	

}
