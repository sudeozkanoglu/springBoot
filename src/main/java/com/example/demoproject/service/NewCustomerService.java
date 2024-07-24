package com.example.demoproject.service;

import com.example.demoproject.entity.NewCustomer;
import com.example.demoproject.repository.CustomerRepository;
import com.example.demoproject.repository.NewCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewCustomerService {

    private final CustomerRepository customerRepository;
    private final NewCustomerRepository newCustomerRepository;

    public List<NewCustomer> getAllNewCustomers() {
        return newCustomerRepository.findAll();
    }

    public void saveNewCustomer(NewCustomer newCustomer) {
        NewCustomer savedCustomer = new NewCustomer();
        savedCustomer.setNewIdentityNumber(newCustomer.getNewIdentityNumber());
        newCustomerRepository.save(newCustomer);
    }

}
