package com.smartcampus.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@PropertySource(value = "classpath:/sql-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
@EnableScheduling
public class DataSourceConfig {

	@Bean(name = "DSLogin")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}										

	@Bean(name = "DSPqrsdf")
	@ConfigurationProperties(prefix="spring.seconddatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean("jdbcLogin")
	public JdbcTemplate createJdbcTemplateLogin(@Autowired @Qualifier("DSLogin") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("jdbcPqrsdf")
	public JdbcTemplate createJdbcTemplateRestriccion(@Autowired @Qualifier("DSPqrsdf") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}