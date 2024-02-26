package com.strelnikov.accountservice.service;

import com.strelnikov.accountservice.entity.Application;
import com.strelnikov.accountservice.repository.ApplicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository postRepository) {
        this.applicationRepository = postRepository;
    }

    @Override
    public Page<Application> findAll(Pageable pageable) {
        return applicationRepository.findAll(pageable);
    }

    @Override
    public Optional<Application> findById(String id) {
        return applicationRepository.findById(id);
    }

    @Override
    public Page<Application> findAllByJobId(String jobId, Pageable pageable) {
        return applicationRepository.findAllByJobId(jobId, pageable);
    }

    @Override
    public Application save(Application toSave) {
        return applicationRepository.save(toSave);
    }

    @Override
    public Application update(String id, Application toSave) {
        toSave.setId(id);
        return applicationRepository.save(toSave);
    }

    @Override
    public void delete(String id) {
        applicationRepository.deleteById(id);
    }
}
