package com.example.demoproject.repository;

//Repository interfacesi database ile iletişim için kullanılacak

import com.example.demoproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Customer yarattığımız entity
    //Long - Customer'ın Primary Key değeri ID olduğundan ve onun da türü Long olduğu için parametre değeri

    //JPA database'de yapılacak olan sorguların - LINQ ifadelerin yazılmadan kolayca istenilen verilerin bulunmasını sağlar.
}
