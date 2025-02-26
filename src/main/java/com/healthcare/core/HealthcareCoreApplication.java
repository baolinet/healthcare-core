package com.healthcare.core;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.sql.Connection;
import java.sql.Statement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication()
public class HealthcareCoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HealthcareCoreApplication.class, args);
	}

	@Bean
	// @Profile("!prod")
	CommandLineRunner runner() {
		return args -> {
			System.out.println("runner");
		};
	}
}
