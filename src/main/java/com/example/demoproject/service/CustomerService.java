package com.example.demoproject.service;

import com.example.demoproject.entity.Customer;
import com.example.demoproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//Customer ile alakalı temel işlemlerin yapılacağı class

@Service
@RequiredArgsConstructor //Lombok - Customer Repository nin constructorının yazılmasına gerek kalmadan bizim için bulur
public class CustomerService {

    //İşlemler database ile alakalı olduğu içni ve database ile ilgili işlemleri Repository de yaptığım için Repository'i implemente etmem gerek
    private final CustomerRepository customerRepository;

    //Database için kullanılacak metotlar
    //Tüm kullıcılar için döneceğimizden List kullanmamız gerek ve array olmamalı çünkü sayı belli değil
    public List<Customer> getAllCustomers()
    {
        //Tüm kullanıcıları databaseden çeker
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer)
    {
        Customer customerSaved = new Customer(); //yeni customer yarat
        customerSaved.setCustomerfirstName(customer.getCustomerfirstName()); //ilgili özelliklerini kullanıcıdan al
        customerSaved.setCustomerlastName(customer.getCustomerlastName());
        customerSaved.setCustomerIdentityNumber(customer.getCustomerIdentityNumber());
        customerSaved.setCustomerRecordNumber(customer.getCustomerRecordNumber());
        customerSaved.setCustomerMarialStatus(customer.getCustomerMarialStatus());
        customerSaved.setCustomerGender(customer.getCustomerGender());
        customerSaved.setCustomerBirthData(customer.getCustomerBirthData());
        customerSaved.setCustomerType(customer.getCustomerType());
        customerRepository.save(customerSaved); //database e kaydet
    }

    //LOMBOK - RequiredArgsConstructor kullanmasaydık yazmamız gereken constructor - Dependency Injection
    /*public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }*/

}
