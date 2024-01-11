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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(double roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getListOfReservations() {
        return listOfReservations;
    }

    public void setListOfReservations(List<Reservation> listOfReservations) {
        this.listOfReservations = listOfReservations;
    }
}
