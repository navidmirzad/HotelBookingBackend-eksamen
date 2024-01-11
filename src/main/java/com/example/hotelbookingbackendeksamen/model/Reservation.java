package com.example.hotelbookingbackendeksamen.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    private String reservationDate;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Reservation() {
    }

    // JPA MAPPING

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guestId")
    private Guest guest;

}
