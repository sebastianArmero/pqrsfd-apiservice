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
import com.smartcampus.models.Medio;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IMedioRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.MedioRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class MedioJDBCRepositoryImpl implements IMedioRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Medio r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_medio( medi_nombre, medi_registradopor, medi_modificadopor,medi_procesoauditoria) VALUES (?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					ps.setString(1, r.getMediNombre());
					ps.setString(2, r.getMediRegistradopor());
					ps.setString(3, r.getMediModificadopor());
					ps.setString(4, r.getMediProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getMediId() + " ya existe");
		}

	}

	@Override
	public List<Medio> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.medio"));
		return jdbc.query(sql.toString(), new MedioRowMapper());
	}

	@Override
	public void update(Long id, Medio r) {
		//medio
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//medio
		
	}

	@Override
	public void delete(Long id) {
		//medio
		
	}

	@Override
	public Medio showById(Long id) {
		//medio
		return null;
	}




}
