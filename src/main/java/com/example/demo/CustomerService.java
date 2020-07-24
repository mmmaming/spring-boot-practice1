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

    public Customer update(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    public Customer findBy(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Customer deleteById(long id) {
        return customerRepository.deleteById(id);
    }
}
