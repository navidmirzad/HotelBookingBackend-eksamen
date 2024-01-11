package com.example.hotelbookingbackendeksamen.service;

import com.example.hotelbookingbackendeksamen.model.Hotel;
import com.example.hotelbookingbackendeksamen.model.Room;
import com.example.hotelbookingbackendeksamen.repositories.HotelRepository;
import com.example.hotelbookingbackendeksamen.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    public void addRoomToHotel(int hotelId, Room room) {
        Optional<Hotel> foundHotel = hotelRepository.findHotelByHotelId(hotelId);

        if (foundHotel.isPresent()) {
            Hotel hotel = foundHotel.get();
            room.setHotel(hotel);
            hotel.getListOfRooms().add(room);
            roomRepository.save(room);
        }
    }



}
