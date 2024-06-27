package com.example.emailservice.service;

import com.example.emailservice.entity.Customer;
import com.example.emailservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private JavaMailSender mailSender;

    @Transactional
    public void sendInvoicesToCustomers() throws MessagingException {
        List<Customer> customers = customerRepo.findAll();

        for (Customer customer:customers){
            byte[] pdfBytes = customer.getInvoice();
            String email = customer.getEmailID();
            String subject = "Invoice " + customer.getInvoiceNo();
            String fileName = "invoice_" + customer.getInvoiceNo() + ".pdf";

            sendEmail(pdfBytes, email, subject, fileName);
        }
    }

    private void sendEmail(byte[] pdfBytes, String email, String subject, String fileName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText("Test", true);

        ByteArrayResource pdf = new ByteArrayResource(pdfBytes);
        helper.addAttachment(fileName, pdf);

        mailSender.send(message);
    }
}
