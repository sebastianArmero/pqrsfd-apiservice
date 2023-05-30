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

import com.smartcampus.models.TipoTipologia;

import com.smartcampus.repositories.ITipoTipologiaRepository;
import com.smartcampus.repositories.rowmapper.RequerimientoRowMapper;
import com.smartcampus.repositories.rowmapper.TipoTipologiaRowMapper;

import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class TipoTipologiaJDBCRepositoryImpl implements ITipoTipologiaRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(TipoTipologia r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_tipotipologia(\r\n"
					+ "titi_nombre,titi_descripcion, titi_nomenclatura, titi_vencimiento,titi_registradopor, titi_procesoauditoria)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?)");
			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					//ps.setInt(1, r.getTipologiaId());
					ps.setString(1, r.getTitiNombre());
					ps.setString(2, r.getTitiDescripcion());
					ps.setString(3, r.getTitiNomenclatura());
					ps.setInt(4, r.getTitiVencimiento());
					ps.setString(5, r.getTitiRegistradopor());
					ps.setString(6, r.getTitiProcesoauditoria());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getTitiId() + " ya existe");
		}

	}

	@Override
	public List<TipoTipologia> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.tipotipologia"));
		return jdbc.query(sql.toString(), new TipoTipologiaRowMapper());
	}

	@Override
	public void update(Long id, TipoTipologia r) {
		
		StringBuilder sqlUpdate = new StringBuilder();
		sqlUpdate.append("\r\n"
				+ "UPDATE public.tb_tipotipologia SET  titi_nombre=?, titi_descripcion=?, titi_nomenclatura=?, titi_vencimiento=?, titi_fechacambio=?, titi_registradopor=?, titi_procesoauditoria=? WHERE titi_id=?");
		jdbc.update(sqlUpdate.toString(),
					r.getTitiNombre(),
					r.getTitiDescripcion(),
					r.getTitiNomenclatura(),
					r.getTitiVencimiento(),
					r.getTitiFechacambio(),
					r.getTitiRegistradopor(),
					r.getTitiProcesoauditoria(),
					id);
		
		
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
	public TipoTipologia showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoTipologia> showByIdTiti(Long id) {
		// TODO Auto-generated method stub
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.tipotipologiaById"));
			return jdbc.query(sql.toString(), new Object[] { id }, new TipoTipologiaRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}




}
