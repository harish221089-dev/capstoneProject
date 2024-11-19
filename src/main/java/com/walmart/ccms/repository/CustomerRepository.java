package com.walmart.ccms.repository;

import com.walmart.ccms.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByUsername(String username);
}
