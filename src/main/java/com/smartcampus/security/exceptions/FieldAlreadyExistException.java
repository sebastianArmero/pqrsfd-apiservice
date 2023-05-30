package com.smartcampus.security.exceptions;

public class FieldAlreadyExistException extends ConflictException {

	private static final long serialVersionUID = 5160762622085581004L;

	public FieldAlreadyExistException(String message) {
		super(message);
	}
}
