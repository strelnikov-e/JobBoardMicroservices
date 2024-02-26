package com.strelnikov.accountservice.service;

import com.strelnikov.accountservice.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ApplicationService {

    Page<Application> findAll(Pageable pageable);

    Optional<Application> findById(String id);

    Application save(Application toSave);

    Application update(String id, Application post);

    void delete(String id);

    Page<Application> findAllByJobId(String jobId, Pageable pageable);
}
