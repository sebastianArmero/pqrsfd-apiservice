package com.smartcampus.controllers;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AbstractTest {

	
    protected static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJhY2MiOjUwNTQwLCJzdWIiOiJmYWNpZnVlbnRlcyIsImNyZWF0ZWQiOjE1OTAyNDkwNzA5NDQsImlhdCI6MTU5MDI0OTA3MH0.28_gNy65tnOyl32pYRXnEf3MJM3oOWfi0o8ZyAS0KJoWA2kc9NbOWFpoz71Dt_gPg-fNyrBTrJrgRd5soDsRoQ";

    @Value("${jwt.header}")
	protected String tokenHeader;
    
	@Autowired
	protected MockMvc mvc;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		return objectMapper.writeValueAsString(obj);
	}

}
