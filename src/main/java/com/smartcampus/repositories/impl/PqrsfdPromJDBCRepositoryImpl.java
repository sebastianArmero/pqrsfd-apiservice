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
import com.smartcampus.models.PqrsfdProm;
import com.smartcampus.models.PqrsfdRec;
import com.smartcampus.repositories.IAsuntoRepository;
import com.smartcampus.repositories.ICargoRepository;
import com.smartcampus.repositories.IPqrsfdCanRepository;
import com.smartcampus.repositories.IPqrsfdPromRepository;
import com.smartcampus.repositories.IPqrsfdRecRepository;
import com.smartcampus.repositories.rowmapper.AsuntoRowMapper;
import com.smartcampus.repositories.rowmapper.CargoRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdCanRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdPromRowMapper;
import com.smartcampus.repositories.rowmapper.PqrsfdRecRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PqrsfdPromJDBCRepositoryImpl implements IPqrsfdPromRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(PqrsfdProm r) {

	}


	
	public List<PqrsfdProm> showByAnios(LocalDate fechaInicio, LocalDate fechaFinal) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DATE_PART('day', COMU.COMU_FECHAENVIADO - (REQU.REQU_FECHARADICADO)) AS dias_de_diferencia FROM  public.tb_requerimiento AS requ,  public.tb_comunicado AS comu WHERE COMU.REQU_ID = REQU.REQU_ID AND requ.requ_fecharadicado  between '"+(fechaInicio)+" ' and '"+(fechaFinal)+" ' ");
		return jdbc.query(sql.toString(), new PqrsfdPromRowMapper());
	}

	@Override
	public void update(Long id, PqrsfdProm r) {
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
	public PqrsfdProm showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PqrsfdProm> showAll() {
		// TODO Auto-generated method stub
		return null;
	}




	





}
