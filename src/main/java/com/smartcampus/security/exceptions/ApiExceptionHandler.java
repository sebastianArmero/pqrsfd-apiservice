package com.smartcampus.security.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.smartcampus.dto.SimpleObjectResponse;

@ControllerAdvice
public class ApiExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class })
	@ResponseBody
	public SimpleObjectResponse notFoundRequest(HttpServletRequest request, Exception exception) {
		return new SimpleObjectResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ BadRequestException.class, org.springframework.dao.DuplicateKeyException.class,
			org.springframework.dao.DataAccessException.class, java.sql.SQLException.class,
			org.springframework.dao.EmptyResultDataAccessException.class,
			org.springframework.web.HttpRequestMethodNotSupportedException.class,
			org.springframework.web.bind.MethodArgumentNotValidException.class,
			org.springframework.web.bind.MissingRequestHeaderException.class,
			org.springframework.web.bind.MissingServletRequestParameterException.class,
			org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
			org.springframework.http.converter.HttpMessageNotReadableException.class })
	@ResponseBody
	public SimpleObjectResponse badRequest(HttpServletRequest request, Exception exception) {
		return new SimpleObjectResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
				request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({ ForbiddenException.class,org.springframework.security.access.AccessDeniedException.class })
	@ResponseBody
	public SimpleObjectResponse forbiddenRequest(HttpServletRequest request, Exception exception) {
		return new SimpleObjectResponse(HttpStatus.FORBIDDEN.value(), exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ ConflictException.class })
	@ResponseBody
	public SimpleObjectResponse conflictRequest(HttpServletRequest request, Exception exception) {
		return new SimpleObjectResponse(HttpStatus.CONFLICT.value(), exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({ UnauthorizedException.class })
	//@ResponseBody
	public void unauthorized() {
		//return new SimpleObjectResponse(HttpStatus.UNAUTHORIZED.value(), "No esta autorizado para acceder al método","");
		// empty. Nothid to do
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public SimpleObjectResponse fatalErrorUnexpectedException(HttpServletRequest request, Exception exception) {
		return new SimpleObjectResponse(HttpStatus.CONFLICT.value(), exception.getMessage(), request.getRequestURI());
	}

}
