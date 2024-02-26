package com.strelnikov.jobservice.repository;

import com.strelnikov.jobservice.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

;

@Repository
public interface PostRepository extends MongoRepository<Job, String> {

}
