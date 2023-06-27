package com.example.gp.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Restaurant> findAll() {
        return restaurantRepo.findAll();
    }

    public List<Restaurant> getAllRestaurantsById(Integer[] restaurantsId) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (int id : restaurantsId) {
            Restaurant restaurantToAdd = this.getRestaurantById(id);
            if(restaurantToAdd != null){
                restaurants.add(restaurantToAdd);
            }
        }
        return restaurants;
    }

    public Restaurant getRestaurantById(int id) {
        return restaurantRepo.findById(id);
    }

    public void addRestaurants(List<Restaurant> restaurants) {
        restaurantRepo.saveAll(restaurants);
    }
}
