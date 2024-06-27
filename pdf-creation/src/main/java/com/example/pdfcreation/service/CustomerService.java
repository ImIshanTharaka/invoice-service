package com.example.pdfcreation.service;

import com.example.pdfcreation.entity.Customer;
import com.example.pdfcreation.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }
}