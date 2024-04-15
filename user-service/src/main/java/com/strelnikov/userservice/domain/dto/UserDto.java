package com.strelnikov.userservice.domain.dto;

import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDto {

    @Id
    private String username;
    private Boolean enabled;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<String> savedJobs = new HashSet<>();

    public UserDto() {
    }

    public UserDto(String username, Boolean enabled, String firstName, String lastName, String email, String phoneNumber, Set<String> savedJobs) {
        this.username = username;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.savedJobs = savedJobs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return getUsername().equals(userDto.getUsername()) && getEnabled().equals(userDto.getEnabled()) && Objects.equals(getFirstName(), userDto.getFirstName()) && Objects.equals(getLastName(), userDto.getLastName()) && Objects.equals(getEmail(), userDto.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getEnabled(), getFirstName(), getLastName(), getEmail(), getPhoneNumber());
    }
}


