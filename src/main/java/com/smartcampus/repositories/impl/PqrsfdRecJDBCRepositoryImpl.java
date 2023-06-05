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
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPqrsfdRecRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdRecRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PqrsfdRecJDBCRepositoryImpl implements IPqrsfdRecRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(PqrsfdRec r) {

	}

	@Override
	public List<PqrsfdRec> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.requpqreci"));
		return jdbc.query(sql.toString(), new PqrsfdRecRowMapper());
	}
	
	@Override
	public List<PqrsfdRec> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT titi_nombre, tire_id, COUNT(tire_id) as total FROM tb_requerimiento, tb_tipotipologia WHERE  tb_requerimiento.tire_id =  tb_tipotipologia.titi_id and tb_requerimiento.requ_fecharadicado between  '"+(fechaInicio)+" ' and '"+(fechaFinal)+" ' GROUP BY titi_nombre, tb_requerimiento.tire_id ORDER BY   COUNT(tire_id) ASC");
		return jdbc.query(sql.toString(), new PqrsfdRecRowMapper());
	}

	@Override
	public void update(Long id, PqrsfdRec r) {
		//recpqr
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//recpqr
		
	}

	@Override
	public void delete(Long id) {
		//recpqr
		
	}

	@Override
	public PqrsfdRec showById(Long id) {
		//recpqr
		return null;
	}

	





}
