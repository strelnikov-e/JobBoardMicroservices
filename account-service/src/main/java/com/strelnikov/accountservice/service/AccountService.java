package com.strelnikov.accountservice.service;

import com.strelnikov.accountservice.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountService {

    Page<Account> findAll(Pageable pageable);

    Optional<Account> findById(String id);

    Account save(Account toSave);

    Account update(String id, Account post);

    void delete(String id);
}
