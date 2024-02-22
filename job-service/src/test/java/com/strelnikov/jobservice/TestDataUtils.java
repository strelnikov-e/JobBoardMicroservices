package com.strelnikov.jobservice;

import com.strelnikov.jobservice.entity.Post;

public class TestDataUtils {

    public static Post create() {
        Post post = new Post();
        post.setFirstName("First");
        post.setLastName("Name");
        post.setCompanyName("Company");
        post.setId("1");
        post.setEmail("test@mail.com");
        return post;

    }
}
