package com.example.demoproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonalEmployee extends Employee{

    @Column(name = "seasonal_identity_number")
    private String seasonalIdentityNumber;

    @Column(name = "seasonal_salary")
    private Double seasonalSalary;

    @Column(name = "seasonal_type")
    private String seasonalType;
}
