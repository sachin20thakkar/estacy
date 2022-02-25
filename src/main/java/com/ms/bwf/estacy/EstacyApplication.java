package com.ms.bwf.estacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class EstacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacyApplication.class, args);
	}

}
