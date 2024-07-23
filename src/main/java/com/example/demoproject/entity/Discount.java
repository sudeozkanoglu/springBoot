package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "discount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;

    @Column(name = "employee_discount")
    private Long employeeDiscount;

    @Column(name = "permanent_discount")
    private Long permanentDiscount;

    //Personel Yakını ile bireçok ilişki
    @OneToMany(mappedBy = "discount")
    private List<Relatives> relatives;

    //Devamlı müşteri ile bireçok ilişki
    @OneToMany(mappedBy = "discount")
    private List<PermanentCustomer> permanentCustomers;
}
