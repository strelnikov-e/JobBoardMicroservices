package com.strelnikov.accountservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "applications")
public class Application {
    @Id
    private String id;
    private String userId;
    private String jobId;
    // ! TO DO ! make status ENUM
    private String status;
    private LocalDate date;
    private URL resumeURL;
    private Map<String, URL> documents = new HashMap<>();

    public Application() {
    }

    public Application(String id, String userId, String jobId, String status, LocalDate date, URL resumeURL, Map<String, URL> documents) {
        this.id = id;
        this.userId = userId;
        this.jobId = jobId;
        this.status = status;
        this.date = date;
        this.resumeURL = resumeURL;
        this.documents.putAll(documents);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public URL getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(URL resumeURL) {
        this.resumeURL = resumeURL;
    }

    public Map<String, URL> getDocuments() {
        return documents;
    }

    public void setDocuments(Map<String, URL> documents) {
        this.documents = documents;
    }

    public void addDocuments(Map<String, URL> documents) {
        this.documents.putAll(documents);
    }
}