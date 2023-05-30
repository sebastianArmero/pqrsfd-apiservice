package com.smartcampus.security.exceptions;

public class MalFormedHeaderException extends BadRequestException{

	private static final long serialVersionUID = -5479999063079847836L;

	public MalFormedHeaderException(String message) {
		super(message);
	}
}
