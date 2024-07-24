package com.example.demoproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentEmployee extends Employee{

    @Column(name = "per_Emp_identity_number")
    private String perEmpIdentityNumber;

    @Column(name = "per_salary")
    private Double perSalary;
}
