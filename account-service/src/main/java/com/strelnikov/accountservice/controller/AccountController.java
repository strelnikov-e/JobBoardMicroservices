package com.strelnikov.accountservice.controller;

import com.strelnikov.accountservice.entity.Account;
import com.strelnikov.accountservice.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:5173")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Returns all the post
    // To add pagination and exclude description field
    @GetMapping
    public Page<Account> allPosts(Pageable pageable) {
        return accountService.findAll(pageable);
    }

    // Get full post description
    // To add exception for id not found
    @GetMapping("/{id}")
    public ResponseEntity<Account> getPost(@PathVariable String id) {
        Account found = accountService.findById(id).orElse(null);
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account toSave) {
        Account account = accountService.save(toSave);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable String id, @RequestBody Account toSave) {
        return new ResponseEntity<>(accountService.update(id, toSave), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        accountService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
