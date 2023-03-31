package com.example.gp.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepo hotelRepo;


    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    public List<Hotel> getAllHotelsById(Integer[] hotelsId) {
        List<Hotel> hotels = new ArrayList<>();
        for (int id : hotelsId) {
            hotels.add(getHotelById(id));
        }
        return hotels;
    }

    public Hotel getHotelById(int hotelId) {
        return hotelRepo.findById(hotelId);
    }

    public void addHotel(Hotel hotel) {
        hotelRepo.save(hotel);
    }
}
