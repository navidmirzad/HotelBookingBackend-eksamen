package com.example.hotelbookingbackendeksamen.repositories;

import com.example.hotelbookingbackendeksamen.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT COUNT(r) FROM Room r WHERE r.hotel.hotelId = :hotelId")
    int countRoomsByHotelId(@Param("hotelId") int hotelId);

}
