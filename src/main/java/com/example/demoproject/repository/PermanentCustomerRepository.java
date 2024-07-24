package com.example.demoproject.repository;

import com.example.demoproject.entity.PermanentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermanentCustomerRepository extends JpaRepository<PermanentCustomer, Long> {
}
