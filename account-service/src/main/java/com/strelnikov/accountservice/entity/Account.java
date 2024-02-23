package com.strelnikov.accountservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

@Document(collection = "accounts")
public class Account {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private List<String> skills = new ArrayList<>();
    private Map<LocalDateTime, String> applied = new HashMap<>();
    private URL resumeURL;
    private Boolean available;

    public Account() {
    }

    public Account(String id, String firstName, String lastName, String phoneNumber, String email, List<String> skills, Map<LocalDateTime, String> applied, URL resumeURL, Boolean available) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.skills = skills;
        this.applied.putAll(applied);
        this.resumeURL = resumeURL;
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) && Objects.equals(getFirstName(), account.getFirstName()) && Objects.equals(getLastName(), account.getLastName()) && Objects.equals(getPhoneNumber(), account.getPhoneNumber()) && Objects.equals(getEmail(), account.getEmail()) && Objects.equals(getSkills(), account.getSkills()) && Objects.equals(getApplied(), account.getApplied()) && Objects.equals(getResumeURL(), account.getResumeURL()) && Objects.equals(getAvailable(), account.getAvailable());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPhoneNumber(), getEmail(), getSkills(), getResumeURL(), getAvailable());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<LocalDateTime, String> getApplied() {
        return applied;
    }

    public void setApplied(Map<LocalDateTime, String> applied) {
        this.applied = applied;
    }

    public URL getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(URL resumeURL) {
        this.resumeURL = resumeURL;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}