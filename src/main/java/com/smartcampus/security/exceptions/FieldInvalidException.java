package com.smartcampus.security.exceptions;

public class FieldInvalidException extends BadRequestException {

	private static final long serialVersionUID = -2500735524153870097L;

	public FieldInvalidException(String message) {
		super(message);
	}
}
