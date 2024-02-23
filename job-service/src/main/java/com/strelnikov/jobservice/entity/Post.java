package com.strelnikov.jobservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String accountId;
    private String companyName;
    private String companyIndustry;
    private String companyDescription;
    private String jobTitle;
    private String numberOfEmployees;
    private String location;
    private String startDate;
    private Integer payMin;
    private Integer payMax;
    private Integer pay;
    private String rate;
    private String description;
    private Boolean available;
    private List<String> benefits = new ArrayList<>();
    private List<String> skills = new ArrayList<>();
    private List<String> jobType = new ArrayList<>();
    private List<String> schedule = new ArrayList<>();
    private List<String> applicants = new ArrayList<>();

    public Post() {
    }

    public Post(String id, String accountId, String companyName, String companyIndustry, String companyDescription, String jobTitle, String numberOfEmployees, String location, String startDate, Integer payMin, Integer payMax, Integer pay, String rate, String description, Boolean available, List<String> benefits, List<String> skills, List<String> jobType, List<String> schedule, List<String> applicants) {
        this.id = id;
        this.accountId = accountId;
        this.companyName = companyName;
        this.companyIndustry = companyIndustry;
        this.companyDescription = companyDescription;
        this.jobTitle = jobTitle;
        this.numberOfEmployees = numberOfEmployees;
        this.location = location;
        this.startDate = startDate;
        this.payMin = payMin;
        this.payMax = payMax;
        this.pay = pay;
        this.rate = rate;
        this.description = description;
        this.available = available;
        this.benefits.addAll(benefits);
        this.skills.addAll(skills);
        this.jobType.addAll(jobType);
        this.schedule.addAll(schedule);
        this.applicants.addAll(applicants);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getId(), post.getId()) && Objects.equals(getAccountId(), post.getAccountId()) && Objects.equals(getCompanyName(), post.getCompanyName()) && Objects.equals(getCompanyIndustry(), post.getCompanyIndustry()) && Objects.equals(getCompanyDescription(), post.getCompanyDescription()) && Objects.equals(getJobTitle(), post.getJobTitle()) && Objects.equals(getNumberOfEmployees(), post.getNumberOfEmployees()) && Objects.equals(getLocation(), post.getLocation()) && Objects.equals(getStartDate(), post.getStartDate()) && Objects.equals(getPayMin(), post.getPayMin()) && Objects.equals(getPayMax(), post.getPayMax()) && Objects.equals(getPay(), post.getPay()) && Objects.equals(getRate(), post.getRate()) && Objects.equals(getDescription(), post.getDescription()) && Objects.equals(getAvailable(), post.getAvailable()) && Objects.equals(getBenefits(), post.getBenefits()) && Objects.equals(getSkills(), post.getSkills()) && Objects.equals(getJobType(), post.getJobType()) && Objects.equals(getSchedule(), post.getSchedule()) && Objects.equals(getApplicants(), post.getApplicants());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getCompanyName(), getCompanyIndustry(), getCompanyDescription(), getJobTitle(), getNumberOfEmployees(), getLocation(), getStartDate(), getPayMin(), getPayMax(), getPay(), getRate(), getDescription(), getAvailable(), getBenefits(), getSkills(), getJobType(), getSchedule(), getApplicants());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getPayMin() {
        return payMin;
    }

    public void setPayMin(Integer payMin) {
        this.payMin = payMin;
    }

    public Integer getPayMax() {
        return payMax;
    }

    public void setPayMax(Integer payMax) {
        this.payMax = payMax;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public void addBenefit(String benefit) {
        this.benefits.add(benefit);
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public List<String> getJobType() {
        return jobType;
    }

    public void setJobType(List<String> jobType) {
        this.jobType = jobType;
    }

    public void addJobType(String type) {
        this.jobType.add(type);
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }

    public void addSchedule(String schedule) {
        this.schedule.add(schedule);
    }

    public List<String> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<String> applicants) {
        this.applicants = applicants;
    }

    public void addApplicant(String applicantId) {
        this.applicants.add(applicantId);
    }
}