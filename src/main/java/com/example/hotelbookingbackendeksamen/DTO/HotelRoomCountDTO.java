package com.example.hotelbookingbackendeksamen.DTO;

import com.example.hotelbookingbackendeksamen.model.Hotel;

public class HotelRoomCountDTO {

    private Hotel hotel;
    private int roomCount;

    public HotelRoomCountDTO() {
    }

    public HotelRoomCountDTO(Hotel hotel, int roomCount) {
        this.hotel = hotel;
        this.roomCount = roomCount;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }
}
