package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permanentCustomer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permanentCustomerId;

    @Column(name = "identity_number")
    private String permanentCustomerIdentityNumber;

    //İndirim
    @ManyToOne
    @JoinColumn(name = "discountId", nullable = false)
    private Discount discount;


}
