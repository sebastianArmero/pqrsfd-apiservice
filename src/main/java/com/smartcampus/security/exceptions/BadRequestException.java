package com.smartcampus.security.exceptions;


public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 5970352206852823054L;
	//private final String DESCRIPTION="Bad request Exceptio";

	public BadRequestException() {
		super();
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}
	
}
