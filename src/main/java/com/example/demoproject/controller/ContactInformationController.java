package com.example.demoproject.controller;

import com.example.demoproject.entity.Activity;
import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.repository.ContactInformationRepository;
import com.example.demoproject.service.ContactInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/contactInformation/v1")
@RequiredArgsConstructor
public class ContactInformationController {

    private final ContactInformationService contactInformationService;
    private final ContactInformationRepository contactInformationRepository;

    @GetMapping(path = "getAllContactInformation")
    public List<ContactInformation> getAllContactInformation() {
        return contactInformationService.getAllContactInformation();
    }

    @PostMapping(path = "savedContactInformation")
    public void saveContactInformation(@RequestBody ContactInformation contactInformation) {
        contactInformationService.saveContactInformation(contactInformation);
    }

    @DeleteMapping(path = "deleteContactInformation/{id}")
    public Map<String, Boolean> deleteContactInformation(@PathVariable(value = "id") Long contact_id) {
        ContactInformation contactInformation = contactInformationRepository.findById(contact_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Information is not found for this id :: " + contact_id));
        contactInformationRepository.delete(contactInformation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

