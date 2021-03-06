package com.example.demo;

import org.hibernate.sql.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getAllCustomer() {
        List<Customer> allCustomer = customerService.getAllCustomer();

        for (Customer customer : allCustomer) {
            System.out.println(customer);

            log.info(customer.toString());
        }
        return "hello user";
    }

    @PutMapping
    public Customer putCustomer(@RequestBody String firstName) {

        log.info(firstName);
        return customerService.save(new Customer("Jack", "Ma"));
    }

    @PostMapping
    public Customer updateCustomer(@RequestBody UpdateRequest updateRequest) {
        log.info(updateRequest.toString());
        Customer customer = customerService.findById(updateRequest.getId());
        customer.setFirstName(updateRequest.getFirstName());
        customer.setLastName(updateRequest.getLastName());
        return customerService.save(customer);
    }

    @GetMapping("/name")
    public Customer findBy(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return customerService.findBy(firstName, lastName);
    }

    @DeleteMapping
    public Customer deleteCustomer(@RequestBody UpdateRequest updateRequest) {
        return customerService.deleteById(updateRequest.getId());
    }
}
