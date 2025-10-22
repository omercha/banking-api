package com.omercha.banking_api.service;

import com.omercha.banking_api.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    void deleteAccount(Long id);

    AccountDto getAccountByID(Long id);

    List<AccountDto> getAllAccounts();

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

}
