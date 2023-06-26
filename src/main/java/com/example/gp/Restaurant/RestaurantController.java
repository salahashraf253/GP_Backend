package com.example.gp.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;



    @GetMapping("")
    public List<Restaurant>findAll(){
        return restaurantService.findAll();
    }

    @PostMapping("")
    public void addRestaurants(@RequestBody List<Restaurant> restaurants){
        restaurantService.addRestaurants(restaurants);
    }

    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable int restaurantId){
        return restaurantService.getRestaurantById(restaurantId);
    }
}
