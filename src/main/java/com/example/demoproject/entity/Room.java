package com.example.demoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(name = "number")
    private int roomNumber;

    @Column(name = "floor")
    private int roomFloor;

    @Column(name = "view")
    private String roomView;

    //Rezervasyon ile
    @OneToMany(mappedBy = "room")
    private List<Rezervation> rezervations;

    @ManyToOne()
    @JoinColumn(name = "roomTypeId", nullable = false)
    private RoomType roomType;
}
