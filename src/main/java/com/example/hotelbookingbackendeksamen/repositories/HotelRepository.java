package com.example.hotelbookingbackendeksamen.repositories;

import com.example.hotelbookingbackendeksamen.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    Optional<Hotel> findHotelByHotelId(int hotelId);

}
