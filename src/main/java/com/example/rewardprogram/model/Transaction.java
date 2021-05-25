package com.example.rewardprogram.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;


}
