package com.strelnikov.jobservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "posts")
public class Job {
    @Id
    private String id;
    private String username;
    private String companyId;
    private String title;
    private String highlights;
    private String description;
    private String location;
    private String jobType;
    private String roleType;
    private String pay;
    private List<String> skills = new ArrayList<>();

    public Job() {
    }

    public Job(String id, String username, String companyId, String title, String highlights, String description, String location, String jobType, String roleType, String pay, List<String> skills) {
        this.id = id;
        this.username = username;
        this.companyId = companyId;
        this.title = title;
        this.highlights = highlights;
        this.description = description;
        this.location = location;
        this.jobType = jobType;
        this.roleType = roleType;
        this.pay = pay;
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}