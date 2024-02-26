package com.strelnikov.jobservice.service;

import com.strelnikov.jobservice.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface JobService {

    Page<Job> findAll(Pageable pageable);

    Optional<Job> findById(String id);

    Job save(Job toSave);

    Job update(String id, Job post);

    void delete(String id);
}
