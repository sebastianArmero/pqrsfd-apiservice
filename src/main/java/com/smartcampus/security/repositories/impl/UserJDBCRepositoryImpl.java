package com.smartcampus.security.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartcampus.security.JwtUserFactory;
import com.smartcampus.security.models.Authority;
import com.smartcampus.security.models.JwtUser;
import com.smartcampus.security.repositories.UserJDBCRepository;
import com.smartcampus.security.repositories.rowmapper.UserRowMapper;

@Repository
public class UserJDBCRepositoryImpl implements UserJDBCRepository {

	@Autowired
	@Qualifier("jdbcLogin")
	private JdbcTemplate jdbc;

	@Autowired
	private AuthorityJDBCRepositoryImpl authorityJDBC;

	@Override
	public JwtUser selectByLogin(String login) {
		List<Authority> list = authorityJDBC.selectByLogin(login);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM apps_uniajc.sec_usuario AS usuario WHERE usuario.login = ?");
		JwtUser user = jdbc.queryForObject(sql.toString(), new Object[] { login }, new UserRowMapper());
		user.setAuthorities(JwtUserFactory.mapToGrantedAuthorities(list));
		return user;
	}

}
