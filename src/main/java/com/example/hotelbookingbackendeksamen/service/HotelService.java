package com.example.hotelbookingbackendeksamen.service;

import com.example.hotelbookingbackendeksamen.DTO.HotelRoomCountDTO;
import com.example.hotelbookingbackendeksamen.DTO.PostHotelDTO;
import com.example.hotelbookingbackendeksamen.model.Hotel;
import com.example.hotelbookingbackendeksamen.model.Room;
import com.example.hotelbookingbackendeksamen.repositories.HotelRepository;
import com.example.hotelbookingbackendeksamen.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

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

    public List<HotelRoomCountDTO> getHotelsWithRoomCount() {
        List<HotelRoomCountDTO> hotelsWithRoomCount = new ArrayList<>();

        List<Hotel> hotels = hotelRepository.findAll();
        for (Hotel hotel : hotels) {
            int roomCount = roomRepository.countRoomsByHotelId(hotel.getHotelId());
            hotelsWithRoomCount.add(new HotelRoomCountDTO(hotel, roomCount));
        }

        return hotelsWithRoomCount;
    }

}
