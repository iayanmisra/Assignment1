package com.cognizant.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;

@Configuration//@ComponentScan(basePackages = "com.cognizant")
public class SpringJava {
	@Bean
	public DataSource dataSourceBean() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setUrl("jdbc:mysql://localhost:3306/today20_03_2020");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		JdbcTemplate js = new JdbcTemplate(ds);
		return js;
	}

	@Bean("studentDao")
	public StudentDao studentDao() {
		return new StudentDaoImpl();
	}
}
