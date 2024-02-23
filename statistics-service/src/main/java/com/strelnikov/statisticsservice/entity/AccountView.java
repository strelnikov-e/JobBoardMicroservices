package com.strelnikov.statisticsservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "views")
public class AccountView {

    @Id
    private String accountId;
    private int count;
    private List<String> viewers;

    public AccountView() {
    }

    public AccountView(String accountId, int count, List<String> viewers) {
        this.accountId = accountId;
        this.count = count;
        this.viewers = viewers;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getViewers() {
        return viewers;
    }

    public void setViewers(List<String> viewers) {
        this.viewers = viewers;
    }
}
