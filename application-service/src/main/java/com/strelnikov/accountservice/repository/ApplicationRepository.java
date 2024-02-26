package com.strelnikov.accountservice.repository;

import com.strelnikov.accountservice.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, String> {

    Page<Application> findAllByJobId(String jobId, Pageable pageable);
}
