package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotel_id;

    @Column(name = "name")
    private String hotelName;

    @Column(name = "owner")
    private String hotelOwner;

    @Column(name = "founding_date")
    private LocalDate hotelFoundingDate;

    @Column(name = "employees_number")
    private Long hotelEmployeesNumber;

    @Column(name = "customer_number")
    private Long hotelCustomerNumber;

    @OneToOne(mappedBy = "hotel")   //Customer ile birebir ilişki
    private Customer customer;

    @OneToOne(mappedBy = "hotel")  //İletişim bilgileri ile birebir ilişki
    private ContactInformation contactInformation;
}