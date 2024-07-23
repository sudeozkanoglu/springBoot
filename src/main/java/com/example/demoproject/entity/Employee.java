package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @Column(name = "emplooyee_name")
    private String employeeName;

    @Column(name = "employee_surname")
    private String employeeSurname;

    @Column(name = "birth_date")
    private LocalDate employeeBirthDate;

    @Column(name = "marial_status")
    private String employeeMarialStatus;

    @Column(name = "type")
    private String employeeType;

    @Column(name = "start_date")
    private LocalDate employeeStartDate;

    @Column(name = "department")
    private String employeeDepartment;

    //Otel ile bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    //Personel Yakını ile bireçok ilişki
    @OneToMany(mappedBy = "employee")
    private List<Relatives> relatives;

    //Etkinlik ile bireçok ilişki
    @OneToMany(mappedBy = "employee")
    private List<Activity> activities;
}
