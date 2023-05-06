package com.istad.dataanalyticresfulapi.service.serviceImpl;

import com.istad.dataanalyticresfulapi.model.Account;
import com.istad.dataanalyticresfulapi.repository.AccountRepository;
import com.istad.dataanalyticresfulapi.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    //inject repository
    private final AccountRepository accountRepository;
    AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public int createAccount(Account account) {
        return 0;
    }

    @Override
    public int updateAccount(Account account, int id) {
        return 0;
    }
    @Override
    public Account findAccountByID(int id) {
        return accountRepository.findAccountByID(id);
    }
}
