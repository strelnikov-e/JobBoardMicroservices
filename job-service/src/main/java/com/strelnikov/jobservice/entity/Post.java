package com.strelnikov.jobservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String companyName;
    private String companyIndustry;
    private String companyDescription;
    private String jobTitle;
    private String numberOfEmployees;
    private String location;
    private List<String> jobType;
    private List<String> schedule;
    private String startDate;
    private Integer payMin;
    private Integer payMax;
    private Integer pay;
    private String rate;
    private List<String> benefits;
    private List<String> competences;
    private String description;

    public Post() {
    }

    public Post(String id, String firstName, String lastName, String phoneNumber, String email,
                String companyName, String companyIndustry, String companyDescription, String jobTitle,
                String numberOfEmployees, String location, List<String> jobType, List<String> schedule,
                String startDate, Integer payMin, Integer payMax, Integer pay, String rate,
                List<String> benefits, List<String> competences, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.companyIndustry = companyIndustry;
        this.companyDescription = companyDescription;
        this.jobTitle = jobTitle;
        this.numberOfEmployees = numberOfEmployees;
        this.location = location;
        this.jobType = jobType;
        this.schedule = schedule;
        this.startDate = startDate;
        this.payMin = payMin;
        this.payMax = payMax;
        this.pay = pay;
        this.rate = rate;
        this.benefits = benefits;
        this.competences = competences;
        this.description = description;
    }

    public static class PostBuilder{
        private String id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String companyName;
        private String companyIndustry;
        private String companyDescription;
        private String jobTitle;
        private String numberOfEmployees;
        private String location;
        private List<String> jobType;
        private List<String> schedule;
        private String startDate;
        private Integer payMin;
        private Integer payMax;
        private Integer pay;
        private String rate;
        private List<String> benefits;
        private List<String> competences;
        private String description;

        public PostBuilder() {
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setCompanyIndustry(String companyIndustry) {
            this.companyIndustry = companyIndustry;
        }

        public void setCompanyDescription(String companyDescription) {
            this.companyDescription = companyDescription;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public void setNumberOfEmployees(String numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setJobType(List<String> jobType) {
            this.jobType = jobType;
        }

        public void setSchedule(List<String> schedule) {
            this.schedule = schedule;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public void setPayMin(Integer payMin) {
            this.payMin = payMin;
        }

        public void setPayMax(Integer payMax) {
            this.payMax = payMax;
        }

        public void setPay(Integer pay) {
            this.pay = pay;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public void setBenefits(List<String> benefits) {
            this.benefits = benefits;
        }

        public void setCompetences(List<String> competences) {
            this.competences = competences;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyIndustry='" + companyIndustry + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", numberOfEmployees='" + numberOfEmployees + '\'' +
                ", location='" + location + '\'' +
                ", jobType=" + jobType +
                ", schedule=" + schedule +
                ", startDate=" + startDate +
                ", payMin=" + payMin +
                ", payMax=" + payMax +
                ", pay=" + pay +
                ", rate='" + rate + '\'' +
                ", benefits=" + benefits +
                ", competences=" + competences +
                '}';
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

    public List<String> getJobType() {
        return jobType;
    }

    public void setJobType(List<String> jobType) {
        this.jobType = jobType;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
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

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
