package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.user" })
public class MyApplicationBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplicationBeApplication.class, args);
	}

}
