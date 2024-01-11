package com.example.hotelbookingbackendeksamen.repositories;

import com.example.hotelbookingbackendeksamen.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


}
