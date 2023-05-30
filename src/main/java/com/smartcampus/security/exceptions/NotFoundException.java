package com.smartcampus.security.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -312178510582626600L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}
	
}