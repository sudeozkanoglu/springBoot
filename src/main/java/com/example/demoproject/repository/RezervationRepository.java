package com.example.demoproject.repository;

import com.example.demoproject.entity.Rezervation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervationRepository extends JpaRepository<Rezervation, Long> {
}
