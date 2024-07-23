package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.service.ContactInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contactInformation/v1")
@RequiredArgsConstructor
public class ContactInformationController {

    private final ContactInformationService contactInformationService;

    @GetMapping(path = "getAllContactInformation")
    public List<ContactInformation> getAllContactInformation() {
        return contactInformationService.getAllContactInformation();
    }

    @PostMapping(path = "savedContactInformation")
    public void saveContactInformation(@RequestBody ContactInformation contactInformation) {
        contactInformationService.saveContactInformation(contactInformation);
    }
}

