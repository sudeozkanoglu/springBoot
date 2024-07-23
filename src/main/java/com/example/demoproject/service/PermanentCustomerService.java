package com.example.demoproject.service;

import com.example.demoproject.entity.Customer;
import com.example.demoproject.entity.PermanentCustomer;
import com.example.demoproject.repository.CustomerRepository;
import com.example.demoproject.repository.PermanentCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermanentCustomerService {
    private final CustomerRepository customerRepository;
    private final PermanentCustomerRepository permanentCustomerRepository;

    public List<PermanentCustomer> getAllPermanentCustomer() {
        return permanentCustomerRepository.findAll();
    }

    public void savePermanentCustomer(PermanentCustomer permanentCustomer) {
        PermanentCustomer permanentCustomerSaved = new PermanentCustomer();
        permanentCustomerSaved.setPermanentCustomerIdentityNumber(permanentCustomer.getPermanentCustomerIdentityNumber());
        permanentCustomerRepository.save(permanentCustomer);
    }
}
