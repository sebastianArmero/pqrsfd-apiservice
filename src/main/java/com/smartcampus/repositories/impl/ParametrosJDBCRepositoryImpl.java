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
import com.smartcampus.models.Parametros;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IParametrosRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.ParametrosRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class ParametrosJDBCRepositoryImpl implements IParametrosRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Parametros r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_parametros(para_vencimiento, para_alertadias, para_registradpor, para_procesoauditoria) VALUES (?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					//ps.setInt(1, r.getTipologiaId());
					ps.setInt(1, r.getParaVencimiento());
					ps.setInt(2, r.getParaAlertadias());
					ps.setString(3, r.getParaRegistradpor());
					ps.setString(4, r.getParaProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getParaId() + " ya existe");
		}

	}

	@Override
	public List<Parametros> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.parametros"));
		return jdbc.query(sql.toString(), new ParametrosRowMapper());
	}

	@Override
	public void update(Long id, Parametros r) {
		//parametros
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//parametros
		
	}

	@Override
	public void delete(Long id) {
		//parametros
		
	}

	@Override
	public Parametros showById(Long id) {
		//parametros
		return null;
	}




}
