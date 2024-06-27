package com.example.exceltodatabase.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "pdf-creation", url = "${pdf-creation.url}")
public interface PDFCreationClient {

    @GetMapping("/generate-invoices")
    ResponseEntity<String> getFromPDFCreation();
}
