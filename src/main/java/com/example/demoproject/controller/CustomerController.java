package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.entity.Customer;
import com.example.demoproject.repository.CustomerRepository;
import com.example.demoproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Controller - dış kullanıcıya erişeceği adresler açılır

@RestController //RESTAPI kullandığım için
@RequestMapping(path = "/customer/v1") //Yönlendirme sağlamak için path değerim
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @GetMapping(path = "getAllCustomers")
    public List<Customer>getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping(path = "savedCustomer")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @DeleteMapping(path = "deleteCustomer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId) {
        return customerService.deleteCustomer(customerId);
    }
}
