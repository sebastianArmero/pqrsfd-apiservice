package com.smartcampus.commons;

import com.google.gson.Gson;

public class GenerateJson {

	public static final GenerateJson JSON = new GenerateJson();
	
	public static GenerateJson getJson() {
		return JSON;
	}

	public String respondeOBJSON(Object i) {
		if (i!=null) {			return new Gson().toJson(i);			}else {				return "";			}
	}
}