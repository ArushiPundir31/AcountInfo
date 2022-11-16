package com.acc.service;

import com.acc.entity.Account;
import org.springframework.data.jpa.repository.Query;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface IAccountService {

    public Account addAccount(Account account);

    Account getAccountById(Long accountId) throws AccountNotFoundException;

    @Query(value = "select * from account", nativeQuery = true)
    public List<Account> getAccountList();


}
