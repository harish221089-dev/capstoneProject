package com.walmart.ccms.repository;

import com.walmart.ccms.model.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditCardRepository extends MongoRepository<CreditCard, String> {
    CreditCard findByUsername(String username);
}
