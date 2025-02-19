package com.api.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.api"})
public class SpringBootRestApiExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiExApplication.class, args);
	}

}
