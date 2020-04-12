package com.example.lkw_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lkw_test.model.CustomerTransactionHistory;
import com.example.lkw_test.model.CustomerTransactionHistoryPK;

public interface CustomerTransactionHistoryRepository extends JpaRepository<CustomerTransactionHistory, CustomerTransactionHistoryPK>{

}
