package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @Column(name = "name")
    private String activityName;

    @Column(name = "limit")
    private int limit;

    @Column(name = "target_group")
    private String targetGroup;

    @Column(name = "date")
    private LocalDate activityDate;

    @Column(name = "time")
    private LocalTime activityTime;

    //Otel ile bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    //Calisan ile bireçok ilişki
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
