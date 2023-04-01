package com.example.gp.Hotel.Recommender;

import com.example.gp.Hotel.Hotel;
import com.example.gp.Hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hotels/recommender")
public class HotelRecommenderController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelRecommenderService hotelRecommenderService;

    @GetMapping("/{userId}/{city}")
    public List<Hotel> recommendHotel(@PathVariable int userId,@PathVariable String city){
        return hotelService.getAllHotelsById(hotelRecommenderService.recommend(userId,city));
    }



}
