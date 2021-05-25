package com.example.rewardprogram.controller;

import com.example.rewardprogram.model.RewardPointRequest;
import com.example.rewardprogram.model.Transaction;
import com.example.rewardprogram.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/customer/{id}")
    public List<Transaction> getTransactionByCustomerId(@PathVariable int id){
        List<Transaction> transactions = service.getTransactionByCustomerId(id);
        return transactions;
    }

    @PostMapping("/customer")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        Transaction transactions = service.addTransaction(transaction);
        return transactions;
    }

    @PostMapping("/")
    public int getRewardPoints(@RequestBody RewardPointRequest request){
        int points = service.getPointsByCustomerIdAndMonth(request);
        return points;
    }
}
