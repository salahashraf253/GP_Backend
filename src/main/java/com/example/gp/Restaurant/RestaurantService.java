package com.example.gp.Restaurant;

import com.example.gp.Hotel.Hotel;
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

    public List<Restaurant> getAllHotelsById(Integer[] restaurantsId) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (int id : restaurantsId) {
            restaurants.add(this.getRestaurantById(id));
        }
        return restaurants;
    }

    private Restaurant getRestaurantById(int id) {
        return restaurantRepo.findById(id);
    }
}
