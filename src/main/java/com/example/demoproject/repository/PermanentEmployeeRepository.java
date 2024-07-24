package com.example.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demoproject.entity.PermanentEmployee;

@Repository
public interface PermanentEmployeeRepository extends JpaRepository<PermanentEmployee, Long> {
}
