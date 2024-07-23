package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "relatives")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Relatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relativeId;

    @Column(name = "first_name")
    private String relativeFirstName;

    @Column(name = "last_name")
    private String relativeLastName;

    @Column(name = "identity_number") //Tabloda bu yoktu
    private Long relativeIdentityNumber;

    @Column(name = "record_number")
    private Long relativeRecordNumber;

    @Column(name = "marial_status")
    private String relativeMarialStatus;

    @Column(name = "gender")
    private String relativeGender;

    @Column(name = "birth_data")
    private LocalDate relativeBirthDate;

    @Column(name = "relative_type")
    private String relativeType;

    @ManyToOne //Çalışan
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne //Otel
    @JoinColumn(name = "hotel_id" , nullable = false)
    private Hotel hotel;

    @ManyToOne //İndirim
    @JoinColumn(name = "discount_Id", nullable = false)
    private Discount discount;

    @OneToMany(mappedBy = "relatives") //Rezervasyon
    private List<Rezervation> rezervations;

}
