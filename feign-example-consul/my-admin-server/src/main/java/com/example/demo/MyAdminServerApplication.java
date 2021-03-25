package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

//It's both server and client 

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class MyAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAdminServerApplication.class, args);
	}

}
