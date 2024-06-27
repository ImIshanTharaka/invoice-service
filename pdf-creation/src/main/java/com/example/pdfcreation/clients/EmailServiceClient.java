package com.example.pdfcreation.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "email-service-client", url = "${email-service-client.url}")
public interface EmailServiceClient {

    @GetMapping("/send-invoices")
    ResponseEntity<String> getFromEmailService();
}
