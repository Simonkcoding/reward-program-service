package com.example.rewardprogram.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardPointRequest {
    private int customerId;
    private String year;
    private String month;

}
