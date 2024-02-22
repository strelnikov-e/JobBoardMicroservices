package com.strelnikov.jobservice.service;

import com.strelnikov.jobservice.entity.Post;
import com.strelnikov.jobservice.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Post> findById(String id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post toSave) {
        return postRepository.save(toSave);
    }

    @Override
    public Post update(String id, Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    @Override
    public void delete(String id) {
        postRepository.deleteById(id);
    }
}
