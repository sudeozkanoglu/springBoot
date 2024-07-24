package com.example.demoproject.repository;

import com.example.demoproject.entity.SeasonalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonalEmployeeRepository extends JpaRepository<SeasonalEmployee, Long> {
}
