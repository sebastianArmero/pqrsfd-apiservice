package com.smartcampus.security.exceptions;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 2542001598347948315L;

	public InternalServerErrorException() {
		super();
	}

	public InternalServerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public InternalServerErrorException(String message) {
		super(message);
	}

	public InternalServerErrorException(Throwable cause) {
		super(cause);
	}

}
