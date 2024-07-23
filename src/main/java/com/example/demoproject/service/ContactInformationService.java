package com.example.demoproject.service;

import com.example.demoproject.repository.ContactInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demoproject.entity.ContactInformation;

import java.util.List;

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
}