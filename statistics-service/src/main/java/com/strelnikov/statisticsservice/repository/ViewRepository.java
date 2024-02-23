package com.strelnikov.statisticsservice.repository;

import com.strelnikov.statisticsservice.entity.AccountView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends MongoRepository<AccountView, String> {
}
