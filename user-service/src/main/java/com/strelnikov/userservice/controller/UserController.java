package com.strelnikov.userservice.controller;

import com.strelnikov.userservice.domain.dto.UserDto;
import com.strelnikov.userservice.domain.entity.User;
import com.strelnikov.userservice.domain.mapper.UserMapper;
import com.strelnikov.userservice.service.UserService;
import jakarta.ws.rs.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private UserMapper userMapper = UserMapper.INSTANCE;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create new user
     * @param toSave - required fields should be passed in Request Body.
     * @return HTTP status 204 - CREATED and created account.
     */
    @PostMapping
    public ResponseEntity<String> create(@RequestBody User toSave) {
        log.info("POST request to create user endpoing with user {}", toSave);
        if (userService.usernameExists(toSave)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Username already exists. Please choose a different username.");
        }
        userService.save(toSave);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully.");
    }

    /**
     * Get user details for current user
     * @return account and HTTP status 200 - OK, or HTTP status 404 - NOT FOUND.
     */
    @GetMapping("/details")
    public ResponseEntity<UserDto> getCurrentUser(Principal principal) {
        log.info("GET request to get current user endpoint");
        User found = userService.findByUsername(principal.getName()).orElse(null);
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userMapper.toUserDto(found), HttpStatus.OK);
    }

    /**
     * Find user by its username
     * @param username - id of requested account
     * @return account and HTTP status 200 - OK, or HTTP status 404 - NOT FOUND.
     */
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
        log.info("GET request to get user endpoint with user {}", username);
        User found = userService.findByUsername(username).orElse(null);
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userMapper.toUserDto(found), HttpStatus.OK);
    }

    @PatchMapping("{username}/save-job")
    public ResponseEntity saveJob(@PathVariable String username, @RequestBody Map<String, String> params) {
        if (params.get("jobId") == null || params.get("jobId").isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User user = userService.findByUsername(username)
                .orElseThrow(() -> {throw new NotFoundException("User with ID not found: " + username);});
        user.saveJob(params.get("jobId"));
        userService.patch(user);
        return new ResponseEntity(HttpStatus.OK);
    }


    /**
     * Update user
     * @param username - username of account to update
     * @param toSave - new account object shold be passed in Request Body. ID field should be empty.
     * @return HTTP status 200 OK and updated account.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable String username, @RequestBody User toSave) {
        return new ResponseEntity<>(
                userMapper.toUserDto(userService.update(username, toSave)),
                HttpStatus.OK);
    }

    /**
     * Delete user
     * @param username - username of account to delete
     * @return HTTP status 201 - NO CONTENT
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String username) {
        userService.delete(username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
