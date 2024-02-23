package com.strelnikov.statisticsservice.controller;

import com.strelnikov.statisticsservice.entity.AccountView;
import com.strelnikov.statisticsservice.service.AccountViewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("statistic/views")
public class AccountViewController {

    private AccountViewService accountViewService;

    public AccountViewController(AccountViewService accountViewService) {
        this.accountViewService = accountViewService;
    }

    @GetMapping
    public List<AccountView> getAll() {
        return accountViewService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountView> getViews(@PathVariable String id) {
        AccountView view = accountViewService.getViews(id).orElse(null);
        if (view == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(view, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountView> updateViews(@PathVariable String id, @RequestBody String viewer) {

    }
}
