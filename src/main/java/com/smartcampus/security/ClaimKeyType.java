package com.smartcampus.security;

public enum ClaimKeyType {

	CLAIM_KEY_USERNAME("sub"), CLAIM_KEY_AUDIENCE("audience"), CLAIM_KEY_CREATED("created"), CLAIM_KEY_ID("acc");

	private String value;

	private ClaimKeyType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
