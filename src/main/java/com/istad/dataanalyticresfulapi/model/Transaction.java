package com.istad.dataanalyticresfulapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int id;

    private UserTransaction sender ;
    private UserTransaction receiver;
    private float amount;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm")
    private Timestamp transferAt;



}
