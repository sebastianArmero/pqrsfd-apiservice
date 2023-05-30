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

import com.smartcampus.models.Cargo;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class CargoJDBCRepositoryImpl implements ICargoRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Cargo r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_cargo(\r\n"
					+ "	carg_nombre, carg_fechacambio, carg_registradopor, carg_procesoauditoria)\r\n"
					+ "	VALUES ( ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					//ps.setInt(1, r.getTipologiaId());
					ps.setString(1, r.getCargNombre());
					ps.setString(2, r.getCargRegistradopor());
					ps.setString(3, r.getCargProcesoauditoria());
					ps.setDate(4, (Date) r.getCargFechacambio());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getCargId() + " ya existe");
		}

	}

	@Override
	public List<Cargo> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.cargo"));
		return jdbc.query(sql.toString(), new CargoRowMapper());
	}

	@Override
	public void update(Long id, Cargo r) {
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
	public Cargo showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
