package com.example.emailservice.controller;

import com.example.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("send-emails")
public class SendEmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("send-invoices")
    public ResponseEntity<String> sendEmails() throws MessagingException {
        emailService.sendInvoicesToCustomers();
        return ResponseEntity.ok("Emails sent successfully.");
    }
}
