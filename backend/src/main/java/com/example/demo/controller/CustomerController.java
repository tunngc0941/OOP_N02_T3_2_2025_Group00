package com.example.demo.controller;

import com.example.demo.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {
    private final List<Customer> customers = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(idGen.getAndIncrement());
        customers.add(customer);
        return customer;
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                c.setTen(customer.getTen());
                c.setPhone(customer.getPhone());
                c.setDiaChi(customer.getDiaChi());
                return c;
            }
        }
        throw new NoSuchElementException("Customer not found");
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }
}
