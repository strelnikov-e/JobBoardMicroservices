package com.strelnikov.jobservice.service;

import com.strelnikov.jobservice.entity.Job;
import com.strelnikov.jobservice.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    Logger log = LoggerFactory.getLogger(JobServiceImpl.class);

    private PostRepository postRepository;

    @Value("${spring.application.account-service.url}")
    private String accountBaseUrl;
    private static final String ACCOUNT_POST_URL = "jobPosts/";

    public JobServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Job> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Job> findById(String id) {
        return postRepository.findById(id);
    }

    @Override
    public Job save(Job toSave) {
        return postRepository.save(toSave);
    }

    @Override
    public Job update(String id, Job post) {
        post.setId(id);
        return postRepository.save(post);
    }

    @Override
    public void delete(String id) {
        postRepository.deleteById(id);
    }
}
