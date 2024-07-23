package com.example.demoproject.controller;

import com.example.demoproject.service.PermanentCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.demoproject.entity.PermanentCustomer;


import java.util.List;

@RestController
@RequestMapping(path = "/permanentCustomer/v1")
@RequiredArgsConstructor
public class PermanentCustomerController {
    private final PermanentCustomerService permanentCustomerService;

    @GetMapping(path = "getAllPermanentCustomer")
    public List<PermanentCustomer> getAllPermanentCustomer() {
        return permanentCustomerService.getAllPermanentCustomer();
    }

    @PostMapping(path = "savedPermanentCustomer")
    public void savePermanentCustomer(@RequestBody PermanentCustomer permanentCustomer) {
        permanentCustomerService.savePermanentCustomer(permanentCustomer);
    }
}
