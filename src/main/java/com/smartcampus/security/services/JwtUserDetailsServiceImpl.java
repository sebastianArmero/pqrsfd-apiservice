package com.smartcampus.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartcampus.security.repositories.impl.UserJDBCRepositoryImpl;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserJDBCRepositoryImpl repo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return repo.selectByLogin(login);
	}

}
