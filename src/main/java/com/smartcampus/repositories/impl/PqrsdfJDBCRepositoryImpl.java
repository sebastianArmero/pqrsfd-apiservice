package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.PegeIdDTO;
import com.smartcampus.models.Pqrsdf;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.repositories.IPqrsdfRepository;

import com.smartcampus.repositories.rowmapper.PqrsdfRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;

@Repository
public class PqrsdfJDBCRepositoryImpl implements IPqrsdfRepository {

	@Autowired
	@Qualifier("jdbcPqrsdf")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public void create(Pqrsdf r) {

		try {

			StringBuilder sql = new StringBuilder();
			if (r.getPqrsdfId() < 0) {
				sql.append("INSERT INTO public.tb_pqrsdf(" + " pqrs_pegeid_usuario, pqrs_pegeidreporta, pqrs_detalle, "
						+ "pqrs_tipologia_id, pqrs_tiporecep_id,  " + "pqrs_usuarioext) VALUES (?, ?, ?, ?, ?, ?)");
			} else {
				sql.append("INSERT INTO public.tb_pqrsdf(" + " pqrs_pegeid_usuario, pqrs_pegeidreporta, pqrs_detalle, "
						+ "pqrs_tipologia_id, pqrs_tiporecep_id, " + "pqrs_usuarioext) VALUES (?, ?, ?, ?, ?, ?)");
			}

			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					int seq = 0;
					if (r.getPqrsPegeidUsuario() > 0) {
						seq = 1;
						ps.setLong(1, r.getPqrsPegeidUsuario());
						System.out.println("CREATE -------" + sql.toString() + " PS   >>>>>>>>>>  " + ps.toString());
					}

					ps.setInt(1 + seq, r.getPqrsPegeidreporta());
					ps.setString(2 + seq, r.getPqrsDetalle());
					ps.setInt(3 + seq, r.getPqrsTipologiaId());
					ps.setInt(4 + seq, r.getPqrsTiporecepId());
					// ps.setInt(5 + seq, r.getPqrsEstadoPqrsdfId());
					ps.setBoolean(5 + seq, r.isPqrsUsuarioExt());
					System.out.println("CREATE <<<< " + r.toString());
					ps.execute();
					ps.close();
					return true;
				}
			});
		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El registro con id=" + r.getPqrsPegeidUsuario() + " no existe");
		}

	}

	@Override
	public void update(Long id, Pqrsdf r) {
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
	public List<Pqrsdf> showAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.pqrsdfAll"));
		return jdbc.query(sql.toString(), new PqrsdfRowMapper());
	}

	@Override
	public Pqrsdf showById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pqrsdf showAllByLogin(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pqrsdf findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long createPqrsdf(Pqrsdf r) {
		// KeyHolder keyHolder = new GeneratedKeyHolder();

		StringBuilder sql = new StringBuilder();
		if (r.getPqrsPegeidUsuario() > 0) {

			sql.append("INSERT INTO public.tb_pqrsdf(" + " pqrs_pegeid_usuario, pqrs_pegeidreporta, pqrs_detalle, "
					+ "pqrs_tipologia_id, pqrs_tiporecep_id, " + "pqrs_usuarioext) VALUES (?, ?, ?, ?, ?, ?)");
		} else {
			sql.append("INSERT INTO public.tb_pqrsdf(" + " pqrs_pegeid_usuario, pqrs_pegeidreporta, pqrs_detalle, "
					+ "pqrs_tipologia_id, pqrs_tiporecep_id, " + "pqrs_usuarioext) VALUES (?, ?, ?, ?, ?, ?)");
		}

		KeyHolder holder = new GeneratedKeyHolder();

		jdbc.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {

				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				int seq = 0;
				if (r.getPqrsPegeidUsuario() > 0) {
					seq = 1;
					ps.setLong(1, r.getPqrsPegeidUsuario());
					System.out.println("CREATE -------" + sql.toString() + " PS   >>>>>>>>>>  " + ps.toString());
				}

				ps.setInt(1 + seq, r.getPqrsPegeidreporta());
				ps.setString(2 + seq, r.getPqrsDetalle());
				ps.setInt(3 + seq, r.getPqrsTipologiaId());
				ps.setInt(4 + seq, r.getPqrsTiporecepId());
				// ps.setInt(5 + seq, r.getPqrsEstadoPqrsdfId());
				ps.setBoolean(5 + seq, r.isPqrsUsuarioExt());
				System.out.println("CREATE <<<< " + r.toString());
				return ps;
			}
		}, holder);

		return Long.parseLong(holder.getKeys().get("pqrsdf_id").toString());

	}

	@Override
	public List<Pqrsdf> findByPegeId(PegeIdDTO pegeid) {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.pqrsdfAllByPegeId"));
		return jdbc.query(sql.toString(), new Object[] { pegeid.getPegeId() }, new PqrsdfRowMapper());
	}

	@Override
	public List<Pqrsdf> findByIdentificacion(UserIdentificacionDTO identificacion) {
		StringBuilder sql = new StringBuilder();
		sql.append(env.getProperty("sql.pqrsdfAllByIdentificacion"));

		return jdbc.query(sql.toString(), new Object[] { identificacion.getIdentificacion() }, new PqrsdfRowMapper());

	}

}
