package com.example.demoproject.repository;

import com.example.demoproject.entity.PermanentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermanentCustomerRepository extends JpaRepository<PermanentCustomer, Long> {
}
