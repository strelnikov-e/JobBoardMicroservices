package com.strelnikov.userservice.service;

import com.strelnikov.userservice.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    Optional<User> findByUsername(String username);

    User save(User toSave);

    User patch(User toSave);

    User update(String username, User post);

    void delete(String username);

    boolean usernameExists(User user);
}
