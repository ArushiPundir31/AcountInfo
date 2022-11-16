package com.acc.service;

import com.acc.entity.Account;
import com.acc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long accountId) throws AccountNotFoundException {
        Optional<Account> account = this.accountRepository.findById(accountId);
        if (account.isEmpty())
            throw new AccountNotFoundException("Id Not Found");
        return account.get();
    }

    @Override
    public List<Account> getAccountList() {
        return this.accountRepository.findAll();
    }


}
