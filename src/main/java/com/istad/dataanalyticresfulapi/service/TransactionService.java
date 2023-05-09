package com.istad.dataanalyticresfulapi.service;

import com.github.pagehelper.PageInfo;
import com.istad.dataanalyticresfulapi.model.Transaction;

import java.util.List;

public interface TransactionService {
    PageInfo<Transaction> getAllTransactions(int page, int size);
    int createTransaction(Transaction transaction);
    int deleteTransaction(int id);

}
