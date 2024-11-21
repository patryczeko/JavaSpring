package org.example.ketchup.controllers;

import org.example.ketchup.models.Customer;
import org.example.ketchup.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        return customerRepository.findById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerRepository.deleteById(id);
    }

    @PatchMapping("/{id}/disable")
    public Customer disableCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            Customer customer2 = customer.get();
            customer2.setIsAvailable(false);
            return customerRepository.save(customer2);
        }
        return null;
    }
}
