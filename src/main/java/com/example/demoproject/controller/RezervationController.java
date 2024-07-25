package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.entity.Rezervation;
import com.example.demoproject.repository.RezervationRepository;
import com.example.demoproject.service.CustomerService;
import com.example.demoproject.service.RezervationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/rezervation/v1")
@RequiredArgsConstructor
public class RezervationController {

    private final RezervationService rezervationService;
    private final CustomerService customerService;
    private final RezervationRepository rezervationRepository;

    @GetMapping(path = "getAllRezervations")
    public List<Rezervation> getAllRezervations() {
        return rezervationService.getAllRezervation();
    }

    @PostMapping(path = "saveRezervation")
    public void saveRezervation(@RequestBody Rezervation rezervation) {
        rezervationService.savedRezervation(rezervation);
    }

    @DeleteMapping(path = "deleteReservation/{id}")
    public Map<String, Boolean> deleteReservation(@PathVariable(value = "id") Long rezervationId) {
        return rezervationService.deleteReservation(rezervationId);
    }
}
