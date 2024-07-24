package com.example.demoproject.controller;

import com.example.demoproject.entity.NewCustomer;
import com.example.demoproject.service.NewCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/newCustomer/v1")
@RequiredArgsConstructor
public class NewCustomerController {

    private final NewCustomerService newCustomerService;

    @GetMapping(path = "getAllNewCustomers")
    public List<NewCustomer> getAllNewCustomers() {
        return newCustomerService.getAllNewCustomers();
    }

    @PostMapping(path = "savedNewCustomer")
    public void saveNewCustomer(@RequestBody NewCustomer newCustomer) {
        newCustomerService.saveNewCustomer(newCustomer);
    }
}
