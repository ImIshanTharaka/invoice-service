package com.example.exceltodatabase.controller;

import com.example.exceltodatabase.clients.PDFCreationClient;
import com.example.exceltodatabase.entity.Customer;
import com.example.exceltodatabase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("to-database")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    PDFCreationClient pdfCreationClient;

    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file) throws IOException {     //"file" is the key (in the request body) corresponding to the Excel file
        customerService.saveCustomersToDatabase(file);
        pdfCreationClient.getFromPDFCreation();     //calling the ext. api
        return ResponseEntity.ok(Collections.singletonMap("Message", "Customers data uploaded to the database and saved successfully"));
    }

    @GetMapping("/get-customers-data")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.FOUND);
    }
}
