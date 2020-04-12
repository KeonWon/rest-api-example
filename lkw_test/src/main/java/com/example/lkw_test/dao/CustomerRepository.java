package com.example.lkw_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lkw_test.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
