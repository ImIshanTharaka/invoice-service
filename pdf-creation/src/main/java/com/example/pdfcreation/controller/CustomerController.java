package com.example.pdfcreation.controller;

import com.example.pdfcreation.clients.EmailServiceClient;
import com.example.pdfcreation.service.PdfExporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("invoices")
public class CustomerController {

    @Autowired
    PdfExporterService pdfExporterService;

    @Autowired
    EmailServiceClient emailServiceClient;

    @GetMapping("/generate-invoices")
    public ResponseEntity<String> generateInvoices() throws IOException {
        pdfExporterService.generatePDFs();
        emailServiceClient.getFromEmailService();
        return ResponseEntity.ok("Pdfs created successfully.");
    }


}
