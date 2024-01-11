package com.example.hotelbookingbackendeksamen.controller;

import com.example.hotelbookingbackendeksamen.DTO.PostHotelDTO;
import com.example.hotelbookingbackendeksamen.model.Hotel;
import com.example.hotelbookingbackendeksamen.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class HotelController {


    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getHotels() {
        return ResponseEntity.ok(hotelRepository.findAll());
    }

    @PostMapping("/addhotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody PostHotelDTO postHotelDTO) {
        Hotel newHotel = new Hotel();
        newHotel.setName(postHotelDTO.getName());
        newHotel.setStreet(postHotelDTO.getStreet());
        newHotel.setCity(postHotelDTO.getCity());
        newHotel.setZipcode(postHotelDTO.getZipcode());
        newHotel.setCountry(postHotelDTO.getCountry());

        hotelRepository.save(newHotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
