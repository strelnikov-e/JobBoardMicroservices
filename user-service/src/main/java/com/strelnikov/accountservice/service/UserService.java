package com.strelnikov.accountservice.service;

import com.strelnikov.accountservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    Optional<User> findById(String id);

    User save(User toSave);

    User update(String id, User post);

    void delete(String id);
}
