package com.example.hotelbookingbackendeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private String name;
    private String street;
    private String city;
    private String zipcode;
    private String country;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Hotel() {
    }

    // JPA MAPPING

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Room> listOfRooms = new ArrayList<>();


}
