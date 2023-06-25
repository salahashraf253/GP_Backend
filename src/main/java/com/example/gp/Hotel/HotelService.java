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
        // for(int i=0;i<hotels.size() && i<10;i++){
        //     hotels.add(getHotelById(hotelsId[i]));
        // }
        return hotels;
    }

    public Hotel getHotelById(int hotelId) {
        return hotelRepo.findById(hotelId);
    }

    public void addHotel(List<Hotel> hotels) {
        for(Hotel hotel : hotels) {
            try{
                hotelRepo.save(hotel);
            }
            catch (Exception e){
                printHotelData(hotel);
                System.out.println(e.getMessage());
            }
        }
    }
    private void printHotelData(Hotel hotel){
        System.out.println("---------------------------------");
        System.out.println("Hotel Name: " + hotel.getName());
        System.out.println("Hotel City: " + hotel.getCity());
        System.out.println("Hotel description: " + hotel.getDescription());
     

    }
}
