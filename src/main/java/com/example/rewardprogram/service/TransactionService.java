package com.example.rewardprogram.service;

import com.example.rewardprogram.model.RewardPointRequest;
import com.example.rewardprogram.model.Transaction;
import com.example.rewardprogram.repository.TransactionRepository;
import com.example.rewardprogram.util.PointCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService implements TransactionServiceIF{

    private TransactionRepository repo;

    @Autowired
    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Transaction> getTransactionByCustomerId(int id) {
        List<Transaction> transactions = repo.findAllByCustomerId(id);
        return transactions;
    }


    @Override
    public Transaction addTransaction(Transaction transaction) {
        Transaction t =  repo.save(transaction);
        return t;
    }

    @Override
    public int getPointsByCustomerIdAndMonth(RewardPointRequest request) {
        // un-package request
        int customerId = request.getCustomerId();
        String year = request.getYear();
        String month = request.getMonth();
        // date range for JPA
        LocalDate[] dateRange = generateDateRange(year,month);
        List<Transaction> transactions = repo.findAllByCustomerIdAndPurchaseDateBetween(customerId,dateRange[0],dateRange[1]);
        int points = transactions
                .stream()
                .map(transaction -> new PointCalculator(transaction.getAmount())).mapToInt(PointCalculator::getRewardPoint).sum();
        return points;
    }

    private LocalDate[] generateDateRange(String year,String month){
        LocalDate initial = LocalDate.of(Integer.valueOf(year),Integer.valueOf(month),15 );
        LocalDate start = initial.withDayOfMonth(1);
        LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
        return new LocalDate[]{start,end};
    }
}
