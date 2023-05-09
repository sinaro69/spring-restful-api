package com.istad.dataanalyticresfulapi.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.istad.dataanalyticresfulapi.mapper.TransactionMapper;
import com.istad.dataanalyticresfulapi.model.Transaction;
import com.istad.dataanalyticresfulapi.repository.TransactionRepository;
import com.istad.dataanalyticresfulapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public PageInfo<Transaction> getAllTransactions(int page, int size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(transactionRepository.getAllTransactions());
    }

    @Override
    public int createTransaction(Transaction transaction) {
        return transactionRepository.insertTransaction(transaction);
    }
    @Override
    public int deleteTransaction(int id) {
        return transactionRepository.deleteTransaction(id);
    }


}
