package com.omercha.banking_api.service;

import com.omercha.banking_api.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountByID(Long id);

}
