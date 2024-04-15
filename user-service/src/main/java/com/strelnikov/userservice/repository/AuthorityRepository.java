package com.strelnikov.userservice.repository;

import com.strelnikov.userservice.domain.entity.Authority;
import com.strelnikov.userservice.domain.entity.AuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

}
