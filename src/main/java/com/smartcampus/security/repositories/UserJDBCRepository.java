package com.smartcampus.security.repositories;

import com.smartcampus.security.models.JwtUser;

public interface UserJDBCRepository {

	public JwtUser selectByLogin(String login);
	
}
