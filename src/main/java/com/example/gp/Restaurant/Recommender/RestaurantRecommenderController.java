package com.example.gp.Restaurant.Recommender;

import com.example.gp.Hotel.HotelService;
import com.example.gp.Restaurant.Restaurant;
import com.example.gp.Restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants/recommend")
public class RestaurantRecommenderController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRecommenderService restaurantRecommenderService;

    @GetMapping("/{userId}/{city}")
    public List<Restaurant> recommendRestaurants(@PathVariable int userId, @PathVariable String city){
        return restaurantService.getAllRestaurantsById(restaurantRecommenderService.recommend(userId,city));
    }
}
