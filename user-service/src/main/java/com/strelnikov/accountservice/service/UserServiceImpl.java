package com.strelnikov.accountservice.service;

import com.strelnikov.accountservice.entity.User;
import com.strelnikov.accountservice.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository postRepository) {
        this.userRepository = postRepository;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User toSave) {
        return userRepository.save(toSave);
    }

    @Override
    public User update(String id, User toSave) {
        toSave.setId(id);
        return userRepository.save(toSave);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
