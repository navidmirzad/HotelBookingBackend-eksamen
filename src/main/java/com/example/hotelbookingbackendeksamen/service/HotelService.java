package com.example.hotelbookingbackendeksamen.service;

import com.example.hotelbookingbackendeksamen.DTO.PostHotelDTO;
import com.example.hotelbookingbackendeksamen.model.Hotel;
import com.example.hotelbookingbackendeksamen.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel editHotel(int hotelId, PostHotelDTO editedHotel) {
        Optional<Hotel> foundHotel = hotelRepository.findHotelByHotelId(hotelId);
        Hotel newHotel = null;

        if (foundHotel.isPresent()) {

            newHotel = foundHotel.get();
            newHotel.setName(editedHotel.getName());
            newHotel.setStreet(editedHotel.getStreet());
            newHotel.setCity(editedHotel.getCity());
            newHotel.setZipcode(editedHotel.getZipcode());
            newHotel.setCountry(editedHotel.getCountry());
            hotelRepository.save(newHotel);
        }
        return newHotel;
    }

}
