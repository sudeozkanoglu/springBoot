package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_id;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "town")
    private String town;

    @Column(name = "postal_Code")
    private String postal_Code;

    //Müşteri ile bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    //Hotel ile birebir ilişki
    @OneToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "relatives_id", nullable = false)
    private Relatives relatives;
}
