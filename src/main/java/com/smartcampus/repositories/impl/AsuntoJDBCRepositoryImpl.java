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
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class AsuntoJDBCRepositoryImpl implements IAsuntoRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Asunto r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_asunto(\r\n"
					+ "asun_nombre,asun_registradopor, asun_procesoauditoria)\r\n"
					+ "	VALUES (?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					//ps.setInt(1, r.getTipologiaId());
					ps.setString(1, r.getAsunNombre());
					ps.setString(2, r.getAsunRegistradopor());
					ps.setString(3, r.getAsunProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getAsunId() + " ya existe");
		}

	}

	@Override
	public List<Asunto> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.asunto"));
		return jdbc.query(sql.toString(), new AsuntoRowMapper());
	}

	@Override
	public void update(Long id, Asunto r) {
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
	public Asunto showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
