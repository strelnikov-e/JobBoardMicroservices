package com.strelnikov.accountservice.controller;

import com.strelnikov.accountservice.entity.User;
import com.strelnikov.accountservice.service.UserService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Find all the users.
     * @param pageable - accepts pagination and soring parameters
     * @return page of accounts and Http status 200 - OK.
     */
    @GetMapping
    public Page<User> allAccounts(Pageable pageable) {
        return userService.findAll(pageable);
    }

    /**
     * Find user by its ID
     * @param id - id of requested account
     * @return account and HTTP status 200 - OK, or HTTP status 404 - NOT FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getAccount(@PathVariable String id) {
        User found = userService.findById(id).orElse(null);
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    /**
     * Create new user
     * @param toSave - required fields should be passed in Request Body.
     * @return HTTP status 204 - CREATED and created account.
     */
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User toSave) {
        User user = userService.save(toSave);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PatchMapping("{id}/save-job")
    public ResponseEntity saveJob(@PathVariable String id, @RequestBody Map<String, String> params) {
        User user = userService.findById(id)
                .orElseThrow(() -> {throw new NotFoundException("User with ID not found: " + id);});
        if (params.get("jobId") == null || params.get("jobId").isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        user.addSavedJob(params.get("jobId"));
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }


    /**
     * Update user
     * @param id - ID of account to update
     * @param toSave - new account object shold be passed in Request Body. ID field should be empty.
     * @return HTTP status 200 OK and updated account.
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User toSave) {
        return new ResponseEntity<>(userService.update(id, toSave), HttpStatus.OK);
    }

    /**
     * Delete user
     * @param id - ID of account to delete
     * @return HTTP status 201 - NO CONTENT
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
