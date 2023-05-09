package com.istad.dataanalyticresfulapi.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    int sender_account_id;
    int receiver_account;
    double amount;
    String remark;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm")
    Timestamp transfer_at;
}
