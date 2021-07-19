package com.example.springtutorial.service;

import com.example.springtutorial.exception.CustomerNotFoundException;
import com.example.springtutorial.model.Customer;
import com.example.springtutorial.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(()
                -> new CustomerNotFoundException("Customer with id:" + id +" NOT found."));
    }
}
