package com.example.hotelbookingbackendeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    private double roomNumber;
    private int numberOfBeds;
    private double price;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Room() {
    }

    // JPA MAPPING

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    // remember to add cascadeType.all but only after implementing function = if room reserved, dont access delete
    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<Reservation> listOfReservations = new ArrayList<>();


}
