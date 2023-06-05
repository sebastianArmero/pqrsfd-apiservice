package com.smartcampus.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.smartcampus.models.CrearUserExtDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.repositories.IUsuarioExtRepository;
import com.smartcampus.repositories.rowmapper.UsuarioExtRowMapper;
import com.smartcampus.security.exceptions.BadRequestException;
import com.smartcampus.security.exceptions.NotFoundException;

@Repository
public class UsuarioExtJDBCRepositoryImpl implements IUsuarioExtRepository {

	@Autowired
	@Qualifier("jdbcLogin")
	private JdbcTemplate jdbc;

	@Autowired
	private Environment env;

	@Override
	public UsuarioExt findByIdentificacion(String identificacion) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select sec_usuario.id_usuario, sec_usuario.login, sec_usuario.password, sec_usuario.identificacion, sec_usuario.correo_electronico, sec_usuario.pege_id, sec_usuario.estado, sec_usuario.token_acces_new, sec_usuario.usua_fechacambio, sec_usuarioexterno.documento_tipo, sec_usuarioexterno.primernombre, sec_usuarioexterno.segundonombre, sec_usuarioexterno.primerapellido, sec_usuarioexterno.segundoapellido, sec_usuario.password_new, sec_usuarioexterno.telefono,sec_usuarioexterno.direccion, sec_usuarioexterno.ciudad, sec_usuarioexterno.correo_electronico_adicional, sec_usuarioexterno.celular from apps_uniajc.sec_usuario, apps_uniajc.sec_usuarioexterno where sec_usuario.id_usuario=sec_usuarioexterno.id_usuario and sec_usuario.identificacion='" + identificacion + "'");
			return jdbc.queryForObject(sql.toString(), new UsuarioExtRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario con identificación No.: " + identificacion);
		}
	}

	@Override
	public void createUserExt(CrearUserExtDTO r) {
		try {

			System.out.println("CREATE" + r.toString());
			StringBuilder sqlusuario = new StringBuilder();
			StringBuilder sqlDatosusuarioExt = new StringBuilder();
			StringBuilder sql = new StringBuilder();
			
			if (!r.getIdentificacion().isEmpty() ) {
				sqlusuario.append(
						"INSERT INTO apps_uniajc.sec_usuario(id_usuario, login, password, identificacion, correo_electronico, "
								+ "pege_id, estado, token_acces, password_new, token_acces_new) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				sql.append(
						"INSERT INTO apps_uniajc.sec_usuario_rol(usro_id, usro_registradopor, usua_id, rol_id, estado_sincronizacion) VALUES (?, ?, ?, ?, ?)");

				sqlDatosusuarioExt
						.append("INSERT INTO apps_uniajc.sec_usuarioexterno(id_usuario, documento_tipo, primernombre, segundonombre, primerapellido, segundoapellido, telefono, direccion, ciudad, correo_electronico_adicional, celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				System.out.println("CREATE usuario -------" + sqlusuario.toString()+" PS   >>>>>>>>>>  "+ sqlusuario.toString());

			} else {
				
				System.out.println("CREATE usuario else-------" + sqlusuario.toString()+" PS   >>>>>>>>>>  "+ sqlusuario.toString());
				sqlusuario.append(
						"INSERT INTO apps_uniajc.sec_usuario(id_usuario, login, password, identificacion, correo_electronico, pege_id, estado, token_acces, password_new, token_acces_new) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				sql.append(
						"INSERT INTO apps_uniajc.sec_usuario_rol(usro_id, usro_registradopor, usua_id, rol_id, estado_sincronizacion) VALUES (?, ?, ?, ?, ?)");
				
				sqlDatosusuarioExt.append("INSERT INTO apps_uniajc.sec_usuarioexterno (id_usuario, documento_tipo, primernombre, segundonombre, primerapellido, segundoapellido, telefono, direccion, ciudad, correo_electronico_adicional, celular) vaues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
			}
			System.out.println("CREATE" + sqlusuario.toString());

			jdbc.execute(sqlusuario.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement psuser) throws SQLException, DataAccessException {
					int seq = 1;
					/*if (new Long(r.getIdentificacion()) > 0) {
						seq = 1;
						psuser.setLong(1,new Long(r.getIdentificacion()));
					}*/
					psuser.setLong(1,new Long(r.getIdentificacion()));
					psuser.setString(1 + seq, r.getLogin());
					psuser.setString(2 + seq, "");
					psuser.setString(3 + seq, r.getIdentificacion());
					psuser.setString(4 + seq, r.getCorreoElectronico());
					psuser.setLong(5 + seq, new Integer(r.getIdentificacion()));
					psuser.setString(6 + seq, "ACTIVO");
					psuser.setString(7 + seq, "");
					psuser.setString(8 + seq, "");
					psuser.setString(9 + seq, "");
					System.out.println("CREATE usuario -------" + psuser.toString()+" PS   >>>>>>>>>> sql "+ sqlusuario.toString());
					psuser.execute();
					psuser.close();
					return true;
				}
			});

			jdbc.execute(sql.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					int seq = 0;
					ps.setLong(1, new Long(r.getIdentificacion()));
					ps.setString(2 + seq, "38262");
					ps.setLong(3 + seq, new Long(r.getIdentificacion()));
					ps.setInt(4 + seq, 600);
					ps.setString(5 + seq, "NUEVO");
					ps.execute();
					ps.close();

					return true;
				}
			});
			jdbc.execute(sqlDatosusuarioExt.toString(), new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement psext) throws SQLException, DataAccessException {
					int seq = 0;
					
					psext.setLong(1, new Long(r.getIdentificacion()));
					psext.setString(2 + seq, r.getDocumentoTipo());
					psext.setString(3 + seq, r.getPrimerNombre());
					psext.setString(4 + seq, r.getSegundoNombre());
					psext.setString(5 + seq, r.getPrimerApellido());
					psext.setString(6 + seq, r.getSegundoApellido());
					psext.setString(7 + seq, r.getTelefono());
					psext.setString(8 + seq, r.getDireccion());
					psext.setInt(9 + seq, r.getCiudad());
					psext.setString(10 + seq, r.getCorreoOpcional());
					psext.setString(11 + seq, r.getCelular());
					psext.execute();
					psext.close();

					return true;
				}
			});

		} catch (DuplicateKeyException e) {
			throw new BadRequestException("El usuario con identificacion=" + r.getIdentificacion() + " ya existe");
		}
	}

	@Override
	public UsuarioExt findByLogin(String username) {
		try {
			StringBuilder sql = new StringBuilder();
			// sql.append(env.getProperty("sql.validateloginext"));
			sql.append("select * from apps_uniajc.sec_usuario where login='" + username + "'");
			return jdbc.queryForObject(sql.toString(), new UsuarioExtRowMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario: " + username);
		}
	}

	
	@Override
	public void update(Long id, UsuarioExt r) {
		//usuarioExt

	}

	@Override
	public void deleteWithUpdate(Long id) {
		//usuarioExt

	}

	@Override
	public void delete(Long id) {
		//usuarioExt

	}

	@Override
	public List<UsuarioExt> showAll() {
		//usuarioExt
		return null;
	}

	@Override
	public UsuarioExt showById(Long id) {
		//usuarioExt
		return null;
	}

	@Override
	public UsuarioExt findByLoginAndPassword(String username, String password) {
		//usuarioExt
		return null;
	}

	@Override
	public void create(UsuarioExt r) {
		//usuarioExt
		
	}

	@Override
	public boolean validateByIdentificacion(String identificacion) {
		try {
			UsuarioExt usuario = new UsuarioExt();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"select  sec_usuario.login, 0 id_usuario, '' password_new, '' identificacion, '' correo_electronico, 0 pege_id, '' estado, '' token_acces_new, '' usua_fechacambio, '' documento_tipo, '' segundonombre, '' primerapellido, '' segundoapellido, '' telefono, '' direccion, 0 ciudad, '' correo_electronico_adicional, '' celular, '' primernombre  from apps_uniajc.sec_usuario where sec_usuario.identificacion='"
							+ identificacion + "' limit 1");
			usuario = jdbc.queryForObject(sql.toString(), new UsuarioExtRowMapper());
			System.out.println("Usuario ------------------>  " + usuario.getLogin());
			return (usuario.getLogin().length() >= 1);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario con identificación No.: " + identificacion);
		}
	}

	@Override
	public boolean validateByIdentificacionUserExt(int identificacion) {
		try {
			UsuarioExt userExt = new UsuarioExt();
			StringBuilder sql = new StringBuilder();

			sql.append(
					"select '' login, 0 id_usuario, '' password_new, '' identificacion, '' correo_electronico, 0 pege_id, '' estado, '' token_acces_new, '' usua_fechacambio, '' documento_tipo, '' segundonombre, '' primerapellido, '' segundoapellido, '' telefono, '' direccion, 0 ciudad, '' correo_electronico_adicional, '' celular, sec_usuarioexterno.primernombre from apps_uniajc.sec_usuarioexterno where sec_usuarioexterno.id_usuario="
							+ identificacion + " limit 1");
			userExt = jdbc.queryForObject(sql.toString(), new UsuarioExtRowMapper());

			System.out.println("Usuario Ext ------------------>  " + userExt.getLogin());
			return (userExt.getPrimerNombre().length() >= 1);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encontró el usuario con identificación No.: " + identificacion);
		}
	}

	
}
