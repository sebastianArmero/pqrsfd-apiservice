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
import com.smartcampus.models.TipoUnidad;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.ITipoUnidadRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.TipoUnidadRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class TipoUnidadJDBCRepositoryImpl implements ITipoUnidadRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(TipoUnidad r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_tipounidad(\r\n"
					+ "tiun_nombre,tiun_registradopor, tiun_procesoauditoria)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					//ps.setInt(1, r.getTipologiaId());
					ps.setString(1, r.getTiunNombre());
					ps.setString(2, r.getTiunRegistradopor());
					ps.setString(3, r.getTiunProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getTiunId() + " ya existe");
		}

	}

	@Override
	public List<TipoUnidad> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.tipounidad"));
		return jdbc.query(sql.toString(), new TipoUnidadRowMapper());
	}

	@Override
	public void update(Long id, TipoUnidad r) {
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
	public TipoUnidad showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
