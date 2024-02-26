package com.strelnikov.accountservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Set<String> savedJobs = new HashSet<>();

    public User() {
    }

    public User(String id, String email, String firstName, String lastName, String phoneNumber, Set<String> savedJobs) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.savedJobs = savedJobs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<String> getSavedJobs() {
        return savedJobs;
    }

    public void setSavedJobs(Set<String> savedJobs) {
        this.savedJobs = savedJobs;
    }

    public void addSavedJob(String toSave) {
        this.savedJobs.add(toSave);
    }
}