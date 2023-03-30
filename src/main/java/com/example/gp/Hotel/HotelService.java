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

    //TODO refactor this function
    public List<Hotel> getAllHotelsById(List<Integer> ids) {
        List<Hotel> hotels = new ArrayList<>();
        for (int id : ids) {
            hotels.add(hotelRepo.findById(id));
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
