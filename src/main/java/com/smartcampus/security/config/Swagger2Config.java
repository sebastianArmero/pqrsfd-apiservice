package com.smartcampus.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smartcampus.MainApplication;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage(MainApplication.class.getPackage().getName() + ".controllers"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("RSE-PQRSDF API").description("PQRSDF API reference for developers")
				.termsOfServiceUrl("http://smartcampus.uniajc.edu.co/").license("MIT License")
				.contact(
						new Contact("Smart Campus", "http://smartcampus.uniajc.edu.co/", "calidad.smartcampus.uniajc@gmail.com"))
				.version("1.0").build();
	}

}
