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

import com.smartcampus.models.EstadoPqrsdf;
import com.smartcampus.repositories.IEstadoPqrsdfRepository;

import com.smartcampus.repositories.rowmapper.EstadoPqrsdfRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class EstadoPqrsdfJDBCRepositoryImpl implements IEstadoPqrsdfRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(EstadoPqrsdf r) {
		try {
			StringBuilder sql = new StringBuilder();
			if (r.getEstadoPqrsdfId() < 0) {
				sql.append(
						"INSERT INTO public.tb_estado_pqrsdf(stpq_estadopqrsdf_id, stpq_fechaestado, stpq_pegeid_funcionario, stpq_tipo_estado_id, stpq_estado, stpq_pqrsdf_id) VALUES (?, ?, ?, ?, ?, ?)");
			} else {
				sql.append("INSERT INTO public.tb_estado_pqrsdf(stpq_pqrsdf_id ) VALUES (?)");
			}

			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					int seq = 0;
					if (r.getEstadoPqrsdfId() < 0) {
						seq = 1;
						ps.setLong(1, r.getEstadoPqrsdfId());
					}

					ps.setLong(1 + seq, r.getPqrsdfId());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getPqrsdfId() + " no existe");
		}

	}

	@Override
	public List<EstadoPqrsdf> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.estadoPqrsdf"));
		return jdbc.query(sql.toString(), new EstadoPqrsdfRowMapper());
	}

	@Override
	public void update(Long id, EstadoPqrsdf r) {
		//EstadoPqr
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//EstadoPqr
		
	}

	@Override
	public void delete(Long id) {
		//EstadoPqr
		
	}

	@Override
	public EstadoPqrsdf showById(Long id) {
		//EstadoPqr
		return null;
	}

	@Override
	public EstadoPqrsdf showAllByIdPqrsdf(Long id) {
		//EstadoPqr
		return null;
	}

	@Override
	public EstadoPqrsdf findByIdPqrsdf(Integer id) {
		//EstadoPqr
		return null;
	}

}
