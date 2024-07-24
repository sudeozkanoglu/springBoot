package com.example.demoproject.repository;

import com.example.demoproject.entity.NewCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCustomerRepository extends JpaRepository<NewCustomer, Long> {
}
