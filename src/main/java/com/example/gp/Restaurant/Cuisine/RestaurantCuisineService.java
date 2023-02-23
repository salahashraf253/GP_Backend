package com.example.gp.Restaurant.Cuisine;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RestaurantCuisineService {
    private RestaurantCuisineRepo restaurantCuisinesRepo;

    public RestaurantCuisineService(RestaurantCuisineRepo restaurantCuisinesRepo) {
        this.restaurantCuisinesRepo = restaurantCuisinesRepo;
    }

    public void addCuisines(Set<RestaurantCuisine> restaurantCuisine) {
        this.restaurantCuisinesRepo.saveAll(restaurantCuisine);
    }

    public List<RestaurantCuisine> findAll(){
        return this.restaurantCuisinesRepo.findAll();
    }

    public RestaurantCuisine findById(int cuisineId) {
        return this.restaurantCuisinesRepo.findById(cuisineId);
    }
}