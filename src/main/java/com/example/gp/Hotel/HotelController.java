package com.example.gp.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;


    @GetMapping("")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping("")
    public void addHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(@PathVariable int hotelId) {
        return hotelService.getHotelById(hotelId);
    }


}
