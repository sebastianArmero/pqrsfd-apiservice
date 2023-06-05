package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPqrsfdCanRepository;
import com.smartcampus.repositories.IPqrsfdRecRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdCanRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdRecRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PqrsfdCanJDBCRepositoryImpl implements IPqrsfdCanRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(PqrsfdCan r) {

	}

	@Override
	public List<PqrsfdCan> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.pqrsfdcan"));
		return jdbc.query(sql.toString(), new PqrsfdCanRowMapper());
	}
	
	public List<PqrsfdCan> showByAnioshowByAnio(LocalDate fechaInicio, LocalDate fechaFinal) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tb_medio.medi_nombre,tb_requerimiento.medi_id, COUNT(tb_medio.medi_id) as total FROM tb_requerimiento, tb_medio  WHERE  tb_requerimiento.medi_id =  tb_medio.medi_id and requ_fecharadicado  between  '"+(fechaInicio)+" ' and '"+(fechaFinal)+" '  GROUP BY medi_nombre, tb_requerimiento.medi_id,  tb_medio.medi_id ORDER BY  COUNT(tb_medio.medi_id)  ASC ");
		return jdbc.query(sql.toString(), new PqrsfdCanRowMapper());
	}

	@Override
	public void update(Long id, PqrsfdCan r) {
		//canpqr

		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//canpqr

		
	}

	@Override
	public void delete(Long id) {
		//canpqr

		
	}

	@Override
	public PqrsfdCan showById(Long id) {
		//canpqr

		return null;
	}


	





}
