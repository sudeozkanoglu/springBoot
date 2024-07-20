package com.example.demoproject.controller;

import com.example.demoproject.entity.Customer;
import com.example.demoproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller - dış kullanıcıya erişeceği adresler açılır

@RestController //RESTAPI kullandığım için
@RequestMapping(path = "/customer/v1") //Yönlendirme sağlamak için path değerim
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "getAllCustomers")
    public List<Customer>getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping(path = "savedCustomer")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }
}
