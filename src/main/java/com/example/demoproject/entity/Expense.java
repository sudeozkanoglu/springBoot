package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @Column(name = "type")
    private String expenseType;

    @Column(name = "amount")
    private Double expenseAmount;

    @Column(name = "date")
    private LocalDate expenseDate;

    //Otel
    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;
}
