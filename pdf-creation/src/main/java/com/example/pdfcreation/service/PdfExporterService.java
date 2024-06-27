package com.example.pdfcreation.service;

import com.example.pdfcreation.entity.Customer;
import com.example.pdfcreation.repo.CustomerRepo;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfExporterService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private TemplateEngine templateEngine;

    public void generatePDFs() throws IOException {
        List<Customer> customers = customerService.getCustomers();

        for (Customer customer : customers){

            // Prepare variables to populate the template
            Context context = new Context();
            context.setVariable("accountNumber", customer.getAccountNumber());
            context.setVariable("name", customer.getName());
            context.setVariable("addressLine1", customer.getAddressLine1());
            context.setVariable("addressLine2", customer.getAddressLine2());
            context.setVariable("addressLine3", customer.getAddressLine3());
            context.setVariable("SVATCreditNoteNo", customer.getSVATCreditNoteNo());
            context.setVariable("invoiceNo", customer.getInvoiceNo());
            context.setVariable("customerVATNo", customer.getCustomerVATNo());
            context.setVariable("customerSVATNo", customer.getCustomerSVATNo());
            context.setVariable("subTotal", customer.getSubTotal());
            context.setVariable("TLandCESS", customer.getTLandCESS());
            context.setVariable("Total", customer.getTotal());
            context.setVariable("SVATAmount", customer.getSVATAmount());
            context.setVariable("EmailID", customer.getEmailID());

            // Generate HTML from the template
            String html = templateEngine.process("template", context);

            // Convert HTML to PDF using iText
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            HtmlConverter.convertToPdf(html, outputStream);

            // Save PDF to the database
            customer.setInvoice(outputStream.toByteArray());
            customerRepo.save(customer);

            // Download PDF to local storage
            FileOutputStream fout = new FileOutputStream("C:\\Users\\Ishan_106080\\Desktop\\" + customer.getAccountNumber() + ".pdf");
            outputStream.writeTo(fout);
            outputStream.close();
            outputStream.flush();
            fout.close();
        }
    }
}
