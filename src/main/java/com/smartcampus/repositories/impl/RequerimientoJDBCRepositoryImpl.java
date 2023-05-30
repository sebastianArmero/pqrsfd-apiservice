package com.smartcampus.repositories.impl;

import java.util.Date;
import java.sql.Statement;

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
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.Requerimiento;
import com.smartcampus.models.TipoTipologia;
import com.smartcampus.repositories.IRequerimientoRepository;
import com.smartcampus.repositories.ITipoTipologiaRepository;
import com.smartcampus.repositories.rowmapper.FuncionarioRowMapper;
import com.smartcampus.repositories.rowmapper.RequerimientoRowMapper;
import com.smartcampus.repositories.rowmapper.TipoTipologiaRowMapper;

import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class RequerimientoJDBCRepositoryImpl implements IRequerimientoRepository {
	


	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;
	
	



	@Override
	public String createRequ(Requerimiento r) {
		
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO public.tb_requerimiento(\r\n"
					+ "	asun_id, ciudad_id, tire_id, pege_id, medi_id, requ_otraciudad, requ_radicado, requ_descripcion, requ_fechaterminorespuesta, requ_registradopor, requ_procesoauditoria, requ_estado, unid_idterritorial, proc_id, requ_numdoc, requ_primernom, requ_segunom, requ_primerape, requ_seguape, requ_direc, requ_tel, requ_telop, requ_correo, requ_emailop, requ_url)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			KeyHolder holder = new GeneratedKeyHolder();
			
			jdbc.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					
					PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, r.getAsunId());
					ps.setInt(2, r.getCiudadId());
					ps.setInt(3, r.getTireId());
					ps.setInt(4, r.getPegeId());
					ps.setInt(5, r.getMediId());
					ps.setString(6, r.getRequOtraciudad());
					ps.setString(7, r.getRequRadicado());
					ps.setString(8, r.getRequDescripcion());	
					ps.setDate(9, new java.sql.Date(((Date) r.getRequFechaterminorespuesta()).getTime()));
				//	ps.setDate(9,  new java.sql.Date(((Date)  r.getRequFechaterminorespuesta().getTime());
				//	ps.setDate(9, (Date) r.getRequFechaterminorespuesta());
				//	ps.setDate(10, new java.sql.Date(((Date) r.getRequFechacambio()).getTime()));
					ps.setString(10, r.getRequRegistradopor());
					ps.setString(11, r.getRequProcesoauditoria());
					ps.setString(12, r.getRequEstado());
				//	ps.setDate(14, new java.sql.Date(((Date) r.getRequFecharadicado()).getTime()));
					ps.setInt(13, r.getUnidIdterritorial());
					ps.setInt(14, r.getProcId());
					ps.setInt(15, r.getRequNumDoc());
					ps.setString(16, r.getRequPrimerNom());
					ps.setString(17, r.getRequSeguNom());
					ps.setString(18, r.getRequPrimerApe());
					ps.setString(19, r.getRequSeguApe());
					ps.setString(20, r.getRequDirec());
					ps.setString(21, r.getRequTel());
					ps.setString(22, r.getRequTelOp());
					ps.setString(23, r.getRequCorreo());
					ps.setString(24, r.getRequEmailop());
					ps.setString(25, r.getRequUrl());
					
					return ps;
				}
			},holder); 
			try {
				StringBuilder sqlUpdate = new StringBuilder();
				sqlUpdate.append("UPDATE TB_REQUERIMIENTO SET REQU_RADICADO= REQUESEL.NOMENSEL || '-' || EXTRACT(YEAR FROM REQU_FECHARADICADO)|| '-' ||'00'||REQU_CONSECUTIVO_ID FROM (SELECT REQU.REQU_ID REQUIDSEL, tipologia.titi_nomenclatura NOMENSEL FROM PUBLIC.tb_tipotipologia AS tipologia, PUBLIC.tb_requerimiento as requ WHERE requ.TIRE_ID=tipologia.titi_id AND REQU.REQU_ID=?) AS REQUESEL WHERE  REQUESEL.REQUIDSEL=REQU_ID AND REQU_ID=?");
			      jdbc.update(sqlUpdate.toString(),Long.parseLong(holder.getKeys().get("REQU_ID").toString()), Long.parseLong(holder.getKeys().get("REQU_ID").toString()));
				} catch (DuplicateKeyException e) {
				  throw new BadRequestException("El registro con id=" + holder.getKeys().get("REQU_ID").toString() + " no existe");
			}
			
			
			return holder.getKeys().get("REQU_ID").toString();
			
	}

	@Override
	public List<Requerimiento> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.requerimientomed"));
		return jdbc.query(sql.toString(), new RequerimientoRowMapper());
	}
	
	@Override
	public List<Requerimiento> showAllHist() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.requerimientohist"));
		return jdbc.query(sql.toString(), new RequerimientoRowMapper());
	}

	@Override
	public void update(Long id, Requerimiento r) {
		// TODO Auto-generated method stub
		
		StringBuilder sqlUpdate = new StringBuilder();
		sqlUpdate.append("UPDATE public.tb_requerimiento SET reclasi_tire_id = ? where  requ_id =  ?");
		jdbc.update(sqlUpdate.toString(),
				r.getReclasiTireId(),						
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
	public Requerimiento showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Requerimiento> showByIdRequ(Long id) {
		// TODO Auto-generated method stub
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.requerimientobyid"));
			return jdbc.query(sql.toString(), new Object[] { id }, new RequerimientoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + id);
		}
	}

	@Override
	public List<Requerimiento> showByIdentificacionAll(Long identificacion) {
		// TODO Auto-generated method stub
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.requerimientobyidentificacionall"));
			return jdbc.query(sql.toString(), new Object[] { identificacion }, new RequerimientoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + identificacion);
		}
	}

	@Override
	public List<Requerimiento> showByIdentificacionHistory(Long identificacion) {
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.requerimientobyhist"));
			return jdbc.query(sql.toString(), new Object[] { identificacion }, new RequerimientoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + identificacion);
		}
	}
	
	@Scheduled(cron = "59 59 23 30 11 ?")
	public void scheduled() {
		
			StringBuilder sql = new StringBuilder();
			sql.append(env.getProperty("sql.altersecuence"));
			 jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				 @Override
				 public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException{
					 ps.execute();
					 ps.close();
					 return true;
				 }
				
			});
		System.out.print("---------------------------fdfdfdfd---------------------------------");
	}

	@Override
	public void create(Requerimiento r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Requerimiento> showAllAnonimo() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.requerimientomedAnonimo"));
		return jdbc.query(sql.toString(), new RequerimientoRowMapper());
	}

	@Override
	public void updateEstado(Long id, Requerimiento r) {
		// TODO Auto-generated method stub
		
		StringBuilder sqlUpdate = new StringBuilder();
		sqlUpdate.append("UPDATE public.tb_requerimiento SET requ_estado = ? where  requ_id = ?");
		jdbc.update(sqlUpdate.toString(),
				r.getRequEstado(),						
				id);
		
		
		
	}



	}





