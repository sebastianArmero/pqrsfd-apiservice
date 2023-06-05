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

import com.smartcampus.models.Asunto;
import com.smartcampus.models.Cargo;
import com.smartcampus.models.Trazabilidad;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.ITrazabilidadRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.ComunicadoRowMapper;
import com.smartcampus.repositories.rowmapper.TrazabilidadRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class TrazabilidadJDBCRepositoryImpl implements ITrazabilidadRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Trazabilidad r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_trazabilidad( requ_id, usua_idejecutor, usua_idasignado, traz_descripcion, traz_estado, traz_registradopor, traz_procesoauditoria) VALUES (?, ?, ?, ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
				
					ps.setInt(1, r.getRequId());
					ps.setInt(2, r.getUsuaIdejecutor());
					ps.setInt(3, r.getUsuaIdasignado());
					
					ps.setString(4, r.getTrazDescripcion());
					ps.setString(5, r.getTrazEstado());
					ps.setString(6, r.getTrazRegistradopor());
					ps.setString(7, r.getTrazProcesoauditoria());

					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getTrazId() + " ya existe");
		}

	}

	@Override
	public List<Trazabilidad> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.trazabilidad"));
		return jdbc.query(sql.toString(), new TrazabilidadRowMapper());
	}

	@Override
	public void update(Long id, Trazabilidad r) {
		//trazabilidad
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//trazabilidad
		
	}

	@Override
	public void delete(Long id) {
		//trazabilidad
		
	}

	@Override
	public Trazabilidad showById(Long id) {
		//trazabilidad
		return null;
	}

	@Override
	public List<Trazabilidad> showByIdRequ(Long id) {
		//trazabilidad
			try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.trazabilidadByRequId"));
			return jdbc.query(sql.toString(), new Object[] { id }, new TrazabilidadRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}



}
