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
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPqrsfdAsunRepository;
import com.smartcampus.repositories.IPqrsfdCanRepository;
import com.smartcampus.repositories.IPqrsfdRecRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdAsunRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdCanRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdRecRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PqrsfdAsunJDBCRepositoryImpl implements IPqrsfdAsunRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(PqrsfdAsun r) {

	}

	@Override
	public List<PqrsfdAsun> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.pqrsfdasun"));
		return jdbc.query(sql.toString(), new PqrsfdAsunRowMapper());
	}
	
	@Override
	public List<PqrsfdAsun> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tb_asunto.asun_nombre , tb_requerimiento.asun_id, COUNT(tb_asunto.asun_id) as total FROM tb_requerimiento, tb_asunto  WHERE  tb_requerimiento.asun_id =  tb_asunto.asun_id  and requ_fecharadicado between  '"+(fechaInicio)+" ' and '"+(fechaFinal)+" '  GROUP BY asun_nombre, tb_requerimiento.asun_id,  tb_asunto.asun_id ORDER BY   COUNT(tb_asunto.asun_id) ASC");
		return jdbc.query(sql.toString(), new PqrsfdAsunRowMapper());
	}

	@Override
	public void update(Long id, PqrsfdAsun r) {
		//asuntopqr
		
	}

	@Override
	public void deleteWithUpdate(Long id) {
		//asuntopqr
		
	}

	@Override
	public void delete(Long id) {
		//asuntopqr
		
	}

	@Override
	public PqrsfdAsun showById(Long id) {
		//asuntopqr
		return null;
	}



	





}
