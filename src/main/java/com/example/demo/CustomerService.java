package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }


    public Customer save(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
}
