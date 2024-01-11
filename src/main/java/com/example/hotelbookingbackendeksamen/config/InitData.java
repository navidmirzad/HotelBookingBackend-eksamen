package com.example.hotelbookingbackendeksamen.config;

import com.example.hotelbookingbackendeksamen.model.Hotel;
import com.example.hotelbookingbackendeksamen.model.Room;
import com.example.hotelbookingbackendeksamen.repositories.HotelRepository;
import com.example.hotelbookingbackendeksamen.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    public void generateDummyData() {
        for (int i = 1; i <= 250; i++) {
            Hotel hotel = new Hotel();
            hotel.setName("Dummy Hotel " + i);
            hotel.setStreet("Dummy Street " + i);
            hotel.setCity("Dummy City");
            hotel.setZipcode("12345");
            hotel.setCountry("Dummy Country");
            hotelRepository.save(hotel);

            int numberOfRooms = (int) (Math.random() * 31) + 10; // Random number between 10 and 40

            for (int j = 1; j <= numberOfRooms; j++) {
                Room room = new Room();
                room.setHotel(hotel);
                room.setRoomNumber(j);
                room.setNumberOfBeds((int) (Math.random() * 4) + 1); // Random number between 1 and 4
                room.setPrice(Math.random() * 200 + 50); // Random number between 50 and 250
                roomRepository.save(room);
            }
        }
    }

    @Override
    public void run(String... args) throws Exception {
       // generateDummyData(); if comment removed, it will generate 250 dummy Hotels, with rooms and etc
    }
}
