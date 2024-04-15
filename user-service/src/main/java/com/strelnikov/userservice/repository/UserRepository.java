package com.strelnikov.userservice.repository;

import com.strelnikov.userservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>,PagingAndSortingRepository<User, String> {

    boolean existsByUsername(String username);

    User save(User toSave);

    void deleteByUsername(String username);

    Optional<User> findUserByUsername(String username);
}
