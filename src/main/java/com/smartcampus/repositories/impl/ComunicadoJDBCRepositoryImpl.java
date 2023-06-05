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
import com.smartcampus.models.Comunicado;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IComunicadoRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.ComunicadoRowMapper;
import com.smartcampus.repositories.rowmapper.RequerimientoRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class ComunicadoJDBCRepositoryImpl implements IComunicadoRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Comunicado r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_comunicado(requ_id, comu_descripcion,comu_registradopor, comu_revisadopor, comu_estado,comu_procesoauditoria, comu_observacion, pege_id)	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
				
					ps.setInt(1, r.getRequId());
					ps.setString(2, r.getComuDescripcion());
					ps.setString(3, r.getComuRegistradopor());
					ps.setString(4, r.getComuRevisadopor());	
					ps.setString(5, r.getComuEstado());	
					ps.setString(6, r.getComuProcesoauditoria());
					ps.setString(7, r.getComuObservacion());
					ps.setString(8, r.getPegeId());
					ps.execute();
					ps.close();
					return true;
				}
			});
			try {
				StringBuilder sqlUpdate = new StringBuilder();
				sqlUpdate.append("UPDATE TB_REQUERIMIENTO SET REQU_ESTADO= ? WHERE REQU_ID= ?");
				jdbc.update(sqlUpdate.toString(),"RESUELTO",r.getRequId());
				
			} catch (DuplicateKeyException e) {
				throw new BadRequestException("El registro con id=" + r.getComuId() + " no existe");
			}
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getComuId() + " ya existe");
		}

	}

	@Override
	public List<Comunicado> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.comunicado"));
		return jdbc.query(sql.toString(), new ComunicadoRowMapper());
	}

	@Override
	public void update(Long id, Comunicado r) {
		//Cominicado
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//Cominicado
		
	}

	@Override
	public void delete(Long id) {
		//Cominicado
		
	}

	@Override
	public Comunicado showById(Long id) {
		//Cominicado
		return null;
	}

	@Override
	public List<Comunicado> showByIdRequ(Long id) {
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.comunicadobyrequid"));
			return jdbc.query(sql.toString(), new Object[] { id }, new ComunicadoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}



}
