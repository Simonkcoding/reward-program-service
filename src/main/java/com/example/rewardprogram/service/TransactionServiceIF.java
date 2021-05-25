package com.example.rewardprogram.service;

import com.example.rewardprogram.model.RewardPointRequest;
import com.example.rewardprogram.model.Transaction;

import java.util.List;

public interface TransactionServiceIF {

    List<Transaction> getTransactionByCustomerId(int id);

    Transaction addTransaction(Transaction transaction);

    int getPointsByCustomerIdAndMonth(RewardPointRequest request);
}
