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
import com.smartcampus.models.Radicado;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IRadicadoRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.RadicadoRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class RadicadoJDBCRepositoryImpl implements IRadicadoRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Radicado r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_radicado(radi_anio, radi_numero,radi_registradopor, radi_procesoauditoria) VALUES (?, ?, ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
			
					ps.setInt(1, r.getRadiAnio());
					ps.setInt(2, r.getRadiNumero());
					ps.setString(3, r.getRadiRegistradopor());
					ps.setString(4, r.getRadiProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getRadiId() + " ya existe");
		}

	}

	@Override
	public List<Radicado> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.radicado"));
		return jdbc.query(sql.toString(), new RadicadoRowMapper());
	}

	@Override
	public void update(Long id, Radicado r) {
		//radicado
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//radicado
		
	}

	@Override
	public void delete(Long id) {
		//radicado
		
	}

	@Override
	public Radicado showById(Long id) {
		//radicado
		return null;
	}




}
