package com.example.gp.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Restaurant>findAll(){
        return restaurantRepo.findAll();
    }

}
