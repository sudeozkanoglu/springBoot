package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers") //Database table name
@Inheritance(strategy = InheritanceType.JOINED)
@Data //GET ve SET'leri bizim için yapar - Lombok kütüphanesi sayesinde - (encapsulation - get / set)
@NoArgsConstructor //Lombok - parametresiz constructor
@AllArgsConstructor //Lombok - parametreli constructor
public class Customer {

    //Database görünümü için

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Sıralı şekilde artacağını belirtir
    private Long customerId;

    @Column(name = "first_name")
    private String customerfirstName;

    @Column(name = "last_name")
    private String customerlastName;

    @Column(name = "identity_number") //Tabloda bu yoktu
    private Long customerIdentityNumber;

    @Column(name = "record_number")
    private Long customerRecordNumber;

    @Column(name = "marial_status")
    private String customerMarialStatus;

    @Column(name = "gender")
    private String customerGender;

    @Column(name = "birth_data")
    private LocalDate customerBirthData;

    @Column(name = "customer_type")
    private String customerType;

    //Hotel ile birebir ilişki
    @OneToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    //İletişim bilgileri ile bireçok ilişki
    @OneToMany(mappedBy = "customer")
    private List<ContactInformation>contactInformations;


    //Rezervasyon ile bireçok ilişki
    @OneToMany(mappedBy = "customer")
    private List<Rezervation> rezervations;

}
