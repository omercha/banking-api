package com.omercha.banking_api.service.impl;

import com.omercha.banking_api.dto.AccountDto;
import com.omercha.banking_api.entity.Account;
import com.omercha.banking_api.mapper.AccountMapper;
import com.omercha.banking_api.repository.AccountRepository;
import com.omercha.banking_api.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


}
