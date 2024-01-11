package com.example.hotelbookingbackendeksamen.controller;

import com.example.hotelbookingbackendeksamen.DTO.PostRoomDTO;
import com.example.hotelbookingbackendeksamen.model.Room;
import com.example.hotelbookingbackendeksamen.repositories.RoomRepository;
import com.example.hotelbookingbackendeksamen.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    RoomRepository roomRepository;

    @PostMapping("/addroom/{hotelId}")
    public ResponseEntity<Room> addRoomToHotel(@PathVariable int hotelId, @RequestBody PostRoomDTO room) {
        Room newRoom = new Room();
        newRoom.setRoomNumber(room.getRoomNumber());
        newRoom.setNumberOfBeds(room.getNumberOfBeds());
        newRoom.setPrice(room.getPrice());
        roomRepository.save(newRoom);
        roomService.addRoomToHotel(hotelId, newRoom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
