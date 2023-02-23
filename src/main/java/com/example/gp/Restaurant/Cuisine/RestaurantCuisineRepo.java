package com.example.gp.Restaurant.Cuisine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantCuisineRepo extends JpaRepository<RestaurantCuisine,Long> {
    RestaurantCuisine findById(int cuisineId);
}
