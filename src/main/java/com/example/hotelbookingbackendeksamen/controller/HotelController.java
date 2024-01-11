package com.example.hotelbookingbackendeksamen.controller;

import com.example.hotelbookingbackendeksamen.DTO.PostHotelDTO;
import com.example.hotelbookingbackendeksamen.model.Hotel;
import com.example.hotelbookingbackendeksamen.model.Room;
import com.example.hotelbookingbackendeksamen.repositories.HotelRepository;
import com.example.hotelbookingbackendeksamen.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelService hotelService;

    //CRUD HOTEL

    @GetMapping("/allhotels")
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

    @PutMapping("/edithotel/{hotelId}")
    public ResponseEntity<PostHotelDTO> editHotel(@PathVariable int hotelId, @RequestBody PostHotelDTO editedHotel) {
        hotelService.editHotel(hotelId, editedHotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletehotel/{hotelId}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable int hotelId) {
        hotelRepository.deleteById(hotelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
