package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers") //Database table name
@Data //GET ve SET'leri bizim için yapar - Lombok kütüphanesi sayesinde - (encapsulation - get / set)
@NoArgsConstructor //Lombok - parametresiz constructor
@AllArgsConstructor //Lombok - parametreli constructor
public class Customer {

    //Database görünümü için

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Sıralı şekilde artacağını belirtir
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
