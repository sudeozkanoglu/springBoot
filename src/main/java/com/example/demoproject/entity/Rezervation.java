package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "rezervation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rezervation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rezervationId;

    @Column(name = "checkin_date")
    private LocalDate checkinDate;

    @Column(name = "checkout_date")
    private LocalDate checkoutDate;

    //Müşteri ile bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    //Personel yakını ile bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "relativedId", nullable = false)
    private Relatives relatives;

    //Oda için bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    //Gelir için bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "incomeId", nullable = false)
    private Income income;
}
