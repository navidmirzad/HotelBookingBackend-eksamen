package com.example.hotelbookingbackendeksamen.repositories;

import com.example.hotelbookingbackendeksamen.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    Optional<Guest> findByGuestId(int guestId);
    Optional<Guest> findGuestByUserName(String userName);
    Optional<Guest> findGuestByEmail(String email);
    Optional<Guest> findCustomerByUserNameAndPassword(String userName, String password);

}
