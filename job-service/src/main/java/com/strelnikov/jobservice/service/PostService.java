package com.strelnikov.jobservice.service;

import com.strelnikov.jobservice.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostService {

    Page<Post> findAll(Pageable pageable);

    Optional<Post> findById(String id);

    Post save(Post toSave);

    Post update(String id, Post post);

    void delete(String id);
}
