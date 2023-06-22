package com.example.gp.Restaurant.Cuisine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants/cuisines")
public class RestaurantCuisineController {
    private RestaurantCuisineService restaurantCuisineService;

    public RestaurantCuisineController(RestaurantCuisineService restaurantCuisineService) {
        this.restaurantCuisineService = restaurantCuisineService;
    }

    @GetMapping("")
    public List<RestaurantCuisine> getAllRestaurantCuisine() {
        return restaurantCuisineService.findAll();
    }
    @PostMapping("")
    public void addRestaurantCuisines(@RequestBody List<RestaurantCuisine> restaurantCuisines){
        restaurantCuisineService.addRestaurantCuisine(restaurantCuisines);
    }
}
