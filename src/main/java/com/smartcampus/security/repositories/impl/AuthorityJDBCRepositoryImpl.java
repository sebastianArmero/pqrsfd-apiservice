package com.smartcampus.security.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartcampus.security.models.Authority;
import com.smartcampus.security.repositories.AuthorityJDBCRepository;
import com.smartcampus.security.repositories.rowmapper.AuthorityRowMapper;

@Repository
public class AuthorityJDBCRepositoryImpl implements AuthorityJDBCRepository {

	@Autowired
	@Qualifier("jdbcLogin")
	private JdbcTemplate jdbc;

	@Override
	public List<Authority> selectByLogin(String login) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT rol.rol_id AS ROL_ID, rol.rol_nombre AS ROL_NOMBRE, ");
		sql.append("rol.rol_descripcion AS ROL_DESCRIPCION, rol.rol_tipo AS ROL_TIPO, ");
		sql.append("rol.rol_estado AS ROL_ESTADO, rol.rol_publico AS ROL_PUBLICO ");
		sql.append("FROM apps_uniajc.sec_rol AS rol ");
		sql.append("INNER JOIN apps_uniajc.sec_usuario_rol AS usu_rol ON usu_rol.rol_id = rol.rol_id ");
		sql.append("INNER JOIN apps_uniajc.sec_usuario AS usuario ON usu_rol.usua_id = usuario.id_usuario ");
		sql.append("WHERE usuario.login = ?");
		return jdbc.query(sql.toString(), new Object[] { login }, new AuthorityRowMapper());
	}

}
