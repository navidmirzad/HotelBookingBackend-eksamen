package com.example.hotelbookingbackendeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int phoneNumber;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Guest() {
    }


    // JPA MAPPING

    @OneToMany(mappedBy = "guest")
    @JsonBackReference
    private List<Reservation> listOfGuestReservations = new ArrayList<>();



}
