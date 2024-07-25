package com.example.demoproject.service;

import com.example.demoproject.repository.ContactInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demoproject.entity.ContactInformation;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;

    public List<ContactInformation> getAllContactInformation(){
        return contactInformationRepository.findAll();
    }

    public void saveContactInformation(ContactInformation contactInformation){
        ContactInformation contactInformationSaved = new ContactInformation();
        contactInformationSaved.setPhone_number(contactInformation.getPhone_number());
        contactInformationSaved.setAddress(contactInformation.getAddress());
        contactInformationSaved.setCity(contactInformation.getCity());
        contactInformationSaved.setTown(contactInformation.getTown());
        contactInformationSaved.setPostal_Code(contactInformation.getPostal_Code());
        contactInformationRepository.save(contactInformationSaved);
    }

    public Map<String, Boolean> deleteContactInformation(Long contact_id){
        ContactInformation contactInformation = contactInformationRepository.findById(contact_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Information is not found for this id :: " + contact_id));
        contactInformationRepository.delete(contactInformation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
