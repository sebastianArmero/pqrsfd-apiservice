package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.Asignar;
import com.smartcampus.models.Requerimiento;
import com.smartcampus.models.TipoTipologia;
import com.smartcampus.repositories.IAsignarRepository;
import com.smartcampus.repositories.ITipoTipologiaRepository;
import com.smartcampus.repositories.rowmapper.AsignarRowMapper;
import com.smartcampus.repositories.rowmapper.RequerimientoRowMapper;
import com.smartcampus.repositories.rowmapper.TipoTipologiaRowMapper;

import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class AsignarJDBCRepositoryImpl implements IAsignarRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Asignar r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_asignar(id_usuario, requ_id, asig_creadopor,asig_modificadopor, asig_estadoasignacion, asig_observacion) VALUES (?, ?, ?, ?, ?, ?);");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					ps.setInt(1, r.getIdUsuario());
					ps.setInt(2, r.getRequId());
					ps.setString(3, r.getAsigCreadoPor());
					ps.setString(4, r.getAsigModificadoPor());
					ps.setString(5, r.getAsigEstadoAsignacion());
					ps.setString(6, r.getAsigObservacion());
					ps.execute();
					ps.close();
					return true;
				}
			});
		
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("Al crear el registro con id=" + r.getAsigId() + " ya existe");
		}

	}

	@Override
	public List<Asignar> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.asignarRequerimiento"));
		return jdbc.query(sql.toString(), new AsignarRowMapper());
	}
	
	@Override
	public List<Asignar> showByIdFunc(Long id) {
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.asignarRequerimiento"));
			return jdbc.query(sql.toString(), new Object[] { id }, new AsignarRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}
	@Override
	public void update(Asignar radicado, String requeEstado) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_REQUERIMIENTO SET REQU_ESTADO= ? WHERE REQU_ID= ?");
			jdbc.update(sql.toString(),requeEstado,radicado.getRequId());
		
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("Al actualizar el registro con id=" + radicado.getRequId() + " no existe");
		}
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		// deleteWithUpdate
		
	}

	@Override
	public void delete(Long id) {
		
		
		 StringBuilder sqlDelete = new StringBuilder();
		 sqlDelete.append("DELETE FROM public.tb_asignar WHERE requ_id = ?");
			jdbc.update(sqlDelete.toString(),id);
		
	}

	@Override
	public Asignar showById(Long id) {
	
		return null;
	}

	@Override
	public List<Asignar> showByIdFuncHistory(Long idHist) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.asignarRequerimientoHist"));
			return jdbc.query(sql.toString(), new Object[] { idHist }, new AsignarRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("al buscar por funciionario no se encontró: " + idHist);
		}
	}

	@Override
	public void update(Long id, Asignar r) {
		//update
		
	}

	@Override
	public List<Asignar> showByIdRequ(Long id) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.asignar"));
			return jdbc.query(sql.toString(), new Object[] { id }, new AsignarRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}



	






}
