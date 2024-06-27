package com.example.exceltodatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExcelToDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelToDatabaseApplication.class, args);
	}

}
