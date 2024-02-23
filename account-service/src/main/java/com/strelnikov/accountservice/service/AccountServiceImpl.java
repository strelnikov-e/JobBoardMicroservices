package com.strelnikov.accountservice.service;

import com.strelnikov.accountservice.entity.Account;
import com.strelnikov.accountservice.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository postRepository) {
        this.accountRepository = postRepository;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account toSave) {
        return accountRepository.save(toSave);
    }

    @Override
    public Account update(String id, Account toSave) {
        toSave.setId(id);
        return accountRepository.save(toSave);
    }

    @Override
    public void delete(String id) {
        accountRepository.deleteById(id);
    }
}
