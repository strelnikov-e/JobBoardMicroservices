package com.strelnikov.jobservice.controller;

import com.strelnikov.jobservice.entity.Job;
import com.strelnikov.jobservice.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Returns all the post
    // To add pagination and exclude description field
    @GetMapping
    public Page<Job> allPosts(Pageable pageable) {
        return jobService.findAll(pageable);
    }

    // Get full post description
    // To add exception for id not found
    @GetMapping("/{id}")
    public ResponseEntity<Job> getPost(@PathVariable String id) {
        Job post = jobService.findById(id).orElse(null);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> save(@RequestBody Job toSave) {
        Job post = jobService.save(toSave);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> update(@PathVariable String id, @RequestBody Job post) {
        return new ResponseEntity<>(jobService.update(id, post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        jobService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
