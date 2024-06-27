package com.example.exceltodatabase.service;

import com.example.exceltodatabase.entity.Customer;
import com.example.exceltodatabase.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public void saveCustomersToDatabase(MultipartFile file) throws IOException {
        if (ExcelUploadService.isValidExcelFile(file)){
            List<Customer> customers = ExcelUploadService.getCustomersDataFromExcel(file.getInputStream());
            customerRepo.saveAll(customers);
        }
    }

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }
}
