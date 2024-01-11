package com.example.hotelbookingbackendeksamen.repositories;

import com.example.hotelbookingbackendeksamen.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
