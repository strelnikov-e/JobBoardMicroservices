package com.strelnikov.jobservice.controller;

import com.strelnikov.jobservice.entity.Post;
import com.strelnikov.jobservice.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Returns all the post
    // To add pagination and exclude description field
    @GetMapping
    public Page<Post> allPosts(Pageable pageable) {
        return postService.findAll(pageable);
    }

    // Get full post description
    // To add exception for id not found
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) {
        Post post = postService.findById(id).orElse(null);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post toSave) {
        Post post = postService.save(toSave);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post post) {
        return new ResponseEntity<>(postService.update(id, post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        postService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
