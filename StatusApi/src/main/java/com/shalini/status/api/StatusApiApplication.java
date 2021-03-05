package com.shalini.status.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StatusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatusApiApplication.class, args);
	}

}
