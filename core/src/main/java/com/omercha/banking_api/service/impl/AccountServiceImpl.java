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

    @Override
    public AccountDto getAccountByID(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found."));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found."));
        if (amount > 0) {
            double updatedBalance = account.getBalance() + amount;
            account.setBalance(updatedBalance);
            Account savedAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDto(savedAccount);
        } else {
            throw new RuntimeException("Invalid deposit amount.");
        }
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found."));
        if (amount < account.getBalance() && amount > 0) {
            double updatedBalance = account.getBalance() - amount;
            account.setBalance(updatedBalance);
            Account savedAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDto(savedAccount);
        } else {
            throw new RuntimeException("Invalid withdrawal amount.");
        }
    }


}
