package com.istad.dataanalyticresfulapi.model.response;

import com.istad.dataanalyticresfulapi.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private int id ;
    private String accountName;
    private String accountNumber;
    private String profile;
    private String phoneNumber;
    private int transferLimit;
    private AccountType accountType;
}
