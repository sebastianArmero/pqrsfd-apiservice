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
import com.smartcampus.models.Proceso;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IProcesoRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.ProcesoRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class ProcesoJDBCRepositoryImpl implements IProcesoRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Proceso r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_proceso(proc_nombre, proc_descripcion,proc_registradopor, proc_procesoauditoria) VALUES (?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					
					ps.setString(1, r.getProcNombre());
					ps.setString(2, r.getProcDescripcion());
					ps.setString(3, r.getProcRegistradopor());
					ps.setString(4, r.getProcProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getProcId() + " ya existe");
		}

	}

	@Override
	public List<Proceso> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.proceso"));
		return jdbc.query(sql.toString(), new ProcesoRowMapper());
	}

	@Override
	public void update(Long id, Proceso r) {
		//proceso
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//proceso
		
	}

	@Override
	public void delete(Long id) {
		//proceso
		
	}

	@Override
	public Proceso showById(Long id) {
		//proceso
		return null;
	}



}
