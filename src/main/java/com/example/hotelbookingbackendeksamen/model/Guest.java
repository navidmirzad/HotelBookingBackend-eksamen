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

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public List<Reservation> getListOfGuestReservations() {
        return listOfGuestReservations;
    }

    public void setListOfGuestReservations(List<Reservation> listOfGuestReservations) {
        this.listOfGuestReservations = listOfGuestReservations;
    }
}
