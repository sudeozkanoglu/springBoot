package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentCustomer extends  Customer{

    @Column(name = "permanent_identity_number")
    private String permanentCustomerIdentityNumber;

    //İndirim
    @ManyToOne
    @JoinColumn(name = "discountId", nullable = false)
    private Discount discount;


}
