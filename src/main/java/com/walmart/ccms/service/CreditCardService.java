package com.walmart.ccms.service;

import com.walmart.ccms.model.CreditCard;
import com.walmart.ccms.model.Customer;
import com.walmart.ccms.repository.CreditCardRepository;
import com.walmart.ccms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreditCardService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard addCreditCard(String username, CreditCard.CreditCardDetail creditCardDetail) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        CreditCard creditCard = creditCardRepository.findByUsername(username);
        if (creditCard == null) {
            creditCard = new CreditCard();
            creditCard.setUsername(username);
            creditCard.setNameOnTheCard(customer.getName().getFirst() + " " + customer.getName().getLast());
            creditCard.setCreditcards(new ArrayList<>());
        }

        creditCard.getCreditcards().add(creditCardDetail);
        return creditCardRepository.save(creditCard);
    }
}
