package com.example.hotelbookingbackendeksamen.controller;

import com.example.hotelbookingbackendeksamen.model.Guest;
import com.example.hotelbookingbackendeksamen.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/guests")
    public ResponseEntity<List<Guest>> getGuests() {
        List<Guest> listOfGuests = guestRepository.findAll();
        return new ResponseEntity<>(listOfGuests, HttpStatus.OK);
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<Guest> getGuest(@PathVariable int guestId) {
        Optional<Guest> foundGuest = guestRepository.findByGuestId(guestId);

        if (foundGuest.isPresent()) {
            Guest guest = foundGuest.get();
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createaccount")
    public ResponseEntity<Guest> createAccount(@RequestBody Guest guestInfo) {

        Guest guest = new Guest();
        guest.setUserName(guestInfo.getUserName());
        guest.setPassword(guestInfo.getPassword());
        guest.setFirstName(guestInfo.getFirstName());
        guest.setLastName(guestInfo.getLastName());
        guest.setEmail(guestInfo.getEmail());
        guest.setPhoneNumber(guestInfo.getPhoneNumber());

        Optional<Guest> existingUserName = guestRepository.findGuestByUserName(guest.getUserName());
        Optional<Guest> existingEmail = guestRepository.findGuestByEmail(guest.getEmail());

        if (existingUserName.isPresent() || existingEmail.isPresent()) {
            System.out.println("User/Email already exists");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            System.out.println("User created succesfully");
            guestRepository.save(guest);
            return new ResponseEntity<>(guest, HttpStatus.CREATED);
        }

    }


}
