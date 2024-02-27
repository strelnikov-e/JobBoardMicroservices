package com.strelnikov.accountservice.controller;

import com.strelnikov.accountservice.entity.Application;
import com.strelnikov.accountservice.service.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ApplicationController {

    private ApplicationService applicationService;

    public ApplicationController(ApplicationService accountService) {
        this.applicationService = accountService;
    }

    /**
     * Retrieve a list of applications submitted by the user.
     * @param pageable - accepts pagination and soring parameters
     * @return page of accounts and Http status 200 - OK.
     */
    @GetMapping
    public Page<Application> getAllForUser(Pageable pageable) {
        // TO implement! Get user ID and find jobs by user ID.
        return applicationService.findAll(pageable);
    }

    /**
     * Retrieve a list of applications for specific job.
     * @param pageable - accepts pagination and soring parameters
     * @return page of accounts and Http status 200 - OK.
     */
    @GetMapping("/jobs/{jobId}")
    public Page<Application> getAllForJob(@PathVariable String jobId, Pageable pageable) {
        // TO implement! Get user ID and find jobs by user ID.
        return applicationService.findAllByJobId(jobId, pageable);
    }

    /**
     * Retrieve an application by ID.
     * @param id - id of requested application.
     * @return account and HTTP status 200 - OK, or HTTP status 404 - NOT FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Application> getById(@PathVariable String id) {
        Application found = applicationService.findById(id).orElse(null);
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    /**
     * Submit a job application.
     * @param toSave - job id should be passed in request body.
     * @return HTTP status 204 - CREATED and created account.
     */
    @PostMapping
    public ResponseEntity<Application> submit(@RequestBody Application toSave) {
        Application application = applicationService.save(toSave);
        return new ResponseEntity<>(application, HttpStatus.CREATED);
    }


    /**
     * Update job application
     * @param id - pass ID of application to update as an url parameter.
     * @param toSave - new account object should be passed in Request Body. ID field should be empty.
     * @return HTTP status 200 OK and updated account.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Application> update(@PathVariable String id, @RequestBody Application toSave) {
        return new ResponseEntity<>(applicationService.update(id, toSave), HttpStatus.OK);
    }

    /**
     * Delete application
     * @param id - pass ID of account to delete as an url parameter.
     * @return HTTP status 201 - NO CONTENT
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        applicationService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
