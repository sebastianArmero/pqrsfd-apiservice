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
import com.smartcampus.models.PqrsfdAsun;
import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdEst;
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPqrsfdAsunRepository;
import com.smartcampus.repositories.IPqrsfdCanRepository;
import com.smartcampus.repositories.IPqrsfdEstRepository;
import com.smartcampus.repositories.IPqrsfdRecRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdAsunRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdCanRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdEstRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdRecRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PqrsfdEstJDBCRepositoryImpl implements IPqrsfdEstRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(PqrsfdEst r) {

	}

	@Override
	public List<PqrsfdEst> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.pqrsfdest"));
		return jdbc.query(sql.toString(), new PqrsfdEstRowMapper());
	}
	
	@Override
	public List<PqrsfdEst> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tb_requerimiento.requ_estado , COUNT(tb_requerimiento.requ_estado) as total FROM tb_requerimiento WHERE  tb_requerimiento.requ_estado =  tb_requerimiento.requ_estado  and requ_fecharadicado  between  '"+(fechaInicio)+" ' and '"+(fechaFinal)+" ' GROUP BY tb_requerimiento.requ_estado ORDER BY CASE WHEN (tb_requerimiento.requ_estado) = 'RESUELTO' THEN 0 WHEN (tb_requerimiento.requ_estado) = 'RADICADO' THEN 1 WHEN (tb_requerimiento.requ_estado) = 'EN TRAMITE' THEN 2 WHEN (tb_requerimiento.requ_estado) = 'NO TRAMITADO' THEN 3 WHEN (tb_requerimiento.requ_estado) = 'TRASLADO' THEN 4 ELSE 5 END,  (tb_requerimiento.requ_estado) ");
		return jdbc.query(sql.toString(), new PqrsfdEstRowMapper());
	}

	@Override
	public void update(Long id, PqrsfdEst r) {
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
	public PqrsfdEst showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	





}
