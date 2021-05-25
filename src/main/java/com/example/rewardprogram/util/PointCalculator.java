package com.example.rewardprogram.util;

import lombok.Data;

@Data
public class PointCalculator {

    private Double purchaseAmount;
    private int twoPointsCounts;
    private int fivePointCounts;
    private int rewardPoint;

    public PointCalculator(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.twoPointsCounts = countEvery2Points(purchaseAmount);
        this.fivePointCounts = countEvery5Points(purchaseAmount);
        this.rewardPoint = this.fivePointCounts * 1 + this.twoPointsCounts * 1;
    }

    // after 100, get 1 point for every 2
    private int countEvery2Points(Double amount) {
        if (amount < 100) {
            return 0;
        } else {
            return (int) ((amount - 100) / 2);
        }
    }

    // after 50, get 1 point for every 5
    private int countEvery5Points(Double amount) {
        if (amount < 50) {
            return 0;
        } else {
            return (int) ((amount - 50) / 5);
        }
    }


}
