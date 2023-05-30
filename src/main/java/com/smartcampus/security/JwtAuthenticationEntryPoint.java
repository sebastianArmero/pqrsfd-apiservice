package com.smartcampus.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcampus.dto.SimpleObjectResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -8970718410437077606L;

	/*
	 * This is invoked when user tries to access a secured REST resource without
	 * supplying any credentials We should just send a 401 Unauthorized response
	 * because there is no 'login page' to redirect to
	 */
	/*@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}*/
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		SimpleObjectResponse r;
		if(response.getStatus() == HttpStatus.BAD_REQUEST.value()) {
			r = new SimpleObjectResponse(HttpStatus.BAD_REQUEST.value(),"El token expiró",request.getRequestURI());
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			r = new SimpleObjectResponse(HttpStatus.UNAUTHORIZED.value(),"No autorizado",request.getRequestURI());
		
		}
		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(r));
		response.getWriter().flush();
		response.getWriter().close();
	}

}