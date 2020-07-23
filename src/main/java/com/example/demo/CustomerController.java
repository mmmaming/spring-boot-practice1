package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
//@RequestMapping("/")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String getAllCustomer() {
        List<Customer> allCustomer = customerService.getAllCustomer();

        for (Customer customer : allCustomer) {
            log.info("'*****************'");
            System.out.println(customer);

            log.info(customer.toString());
        }
        return "hello user";
    }

    @GetMapping("/post")
    public Customer putCustomer() {
        return customerService.save(new Customer("Jack", "Ma"));
    }
}
