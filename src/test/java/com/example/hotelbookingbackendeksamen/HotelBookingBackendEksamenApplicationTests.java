package com.example.hotelbookingbackendeksamen;

import com.example.hotelbookingbackendeksamen.DTO.HotelRoomCountDTO;
import com.example.hotelbookingbackendeksamen.model.Hotel;
import com.example.hotelbookingbackendeksamen.model.Room;
import com.example.hotelbookingbackendeksamen.repositories.HotelRepository;
import com.example.hotelbookingbackendeksamen.repositories.RoomRepository;
import com.example.hotelbookingbackendeksamen.service.HotelService;
import com.example.hotelbookingbackendeksamen.service.RoomService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
class HotelBookingBackendEksamenApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RoomService roomService;

    @MockBean
    private HotelRepository hotelRepository;

    @Test
    void testAddRoomToHotel() {
        // Arrange
        int hotelId = 1;

        Room room = new Room();
        room.setRoomId(1);
        room.setNumberOfBeds(2);
        room.setPrice(200);

        Hotel hotel = new Hotel();
        hotel.setHotelId(1);
        hotel.setStreet("street");
        hotel.setCity("cph");
        hotel.setCountry("Denmark");

        // Mock the behavior of hotelRepository
        Mockito.when(hotelRepository.findHotelByHotelId(hotelId))
                .thenReturn(Optional.of(hotel));

        // Act
        roomService.addRoomToHotel(hotelId, room);

        // Assert
        assertNotNull(hotel.getListOfRooms(), "List of rooms should not be null");
        assertTrue(hotel.getListOfRooms().contains(room), "Room should be in the list of rooms");
    }
}
