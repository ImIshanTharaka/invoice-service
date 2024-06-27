package com.example.pdfcreation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PdfCreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfCreationApplication.class, args);
	}

}
