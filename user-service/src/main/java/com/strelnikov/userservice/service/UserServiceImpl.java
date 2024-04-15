package com.strelnikov.userservice.service;

import com.strelnikov.userservice.domain.entity.Authority;
import com.strelnikov.userservice.domain.entity.User;
import com.strelnikov.userservice.repository.AuthorityRepository;
import com.strelnikov.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private PasswordEncoder encoder;
    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository postRepository, AuthorityRepository authorityRepository, PasswordEncoder encoder) {
        this.userRepository = postRepository;
        this.authorityRepository = authorityRepository;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword("{bcrypt}" + encoder.encode(user.getPassword()));
        user.setEnabled(true);
        User saved = userRepository.save(user);
        authorityRepository.save(new Authority(user.getUsername(), user, "ROLE_USER"));
        return user;
    }

    @Override
    public User patch(User toSave) {
        return userRepository.save(toSave);
    }

    @Override
    public boolean usernameExists(User user) {
        return userRepository.existsByUsername(user.getUsername());
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        log.debug("Invoking find user by username: {}", username);
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User update(String username, User toSave) {
        toSave.setUsername(username);
        return userRepository.save(toSave);
    }

    @Override
    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }
}
