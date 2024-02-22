package com.strelnikov.jobservice.repository;

import com.strelnikov.jobservice.TestDataUtils;
import com.strelnikov.jobservice.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PostRepositoryTest {

    @Autowired
    PostRepository repository;

    @Test
    public void shouldFindPostById() {
        Post stub = TestDataUtils.create();
        repository.save(stub);

        Post found = repository.findById(stub.getId()).get();
        assertEquals(stub.getId(), found.getId());
        assertEquals(stub.getFirstName(), found.getFirstName());
        assertEquals(stub.getEmail(), found.getEmail());
    }


}