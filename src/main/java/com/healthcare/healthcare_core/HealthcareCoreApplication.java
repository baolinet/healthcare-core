package com.healthcare.healthcare_core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class HealthcareCoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HealthcareCoreApplication.class, args);
	}

	@Bean
	@Profile("!prod")
	CommandLineRunner runner() {
		return args -> {
			System.out.println("runner");
		};
	}
}
