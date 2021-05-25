package com.example.rewardprogram.repository;

import com.example.rewardprogram.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
    List<Transaction> findAllByCustomerId(int customerId);

    List<Transaction> findAllByCustomerIdAndPurchaseDateBetween(int customerId, LocalDate startDate, LocalDate endDate);
}
