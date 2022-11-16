package com.acc.controller;

//import javax.validation.Valid;
import com.acc.entity.Account;
import com.acc.exception.AccountNotFoundException;
import com.acc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/account")
public class AccountController {

    @Autowired
    IAccountService iAccountService;

    @PostMapping("add")
    public Account addPayment(@RequestBody Account account) {
        return this.iAccountService.addAccount(account);

    }

    @GetMapping("{id}")
    public Account getAccountById(@PathVariable("id") Long accountId) throws AccountNotFoundException, javax.security.auth.login.AccountNotFoundException {
        return this.iAccountService.getAccountById(accountId);
    }


    @GetMapping("accounts")
    public List<Account> getAllAccountDetails() {
        return this.iAccountService.getAccountList();
    }
}
