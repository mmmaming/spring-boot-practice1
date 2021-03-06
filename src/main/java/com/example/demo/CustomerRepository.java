package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    Customer save(Customer customer);

    Customer findByFirstNameAndLastName(String firstName, String lastName);

    Customer deleteById(long id);
}
