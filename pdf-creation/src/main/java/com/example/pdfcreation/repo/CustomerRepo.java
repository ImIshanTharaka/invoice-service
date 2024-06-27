package com.example.pdfcreation.repo;

import com.example.pdfcreation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
