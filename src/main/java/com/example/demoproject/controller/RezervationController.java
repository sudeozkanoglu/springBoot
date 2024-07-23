package com.example.demoproject.controller;

import com.example.demoproject.entity.Rezervation;
import com.example.demoproject.service.CustomerService;
import com.example.demoproject.service.RezervationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rezervation/v1")
@RequiredArgsConstructor
public class RezervationController {

    private final RezervationService rezervationService;
    private final CustomerService customerService;

    @GetMapping(path = "getAllRezervations")
    public List<Rezervation> getAllRezervations() {
        return rezervationService.getAllRezervation();
    }

    @PostMapping(path = "saveRezervation")
    public void saveRezervation(@RequestBody Rezervation rezervation) {
        rezervationService.savedRezervation(rezervation);
    }
}
