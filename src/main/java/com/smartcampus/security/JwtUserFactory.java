package com.smartcampus.security;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.smartcampus.security.models.Authority;

public final class JwtUserFactory {

	private JwtUserFactory() {

	}

	public static Set<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getRolTipo()))
				.collect(Collectors.toSet());
	}

}
