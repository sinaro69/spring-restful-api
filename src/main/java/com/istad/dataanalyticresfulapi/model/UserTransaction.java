package com.istad.dataanalyticresfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserTransaction {
    private int accountId;
    private String accountNumber;
    private User user;
}
