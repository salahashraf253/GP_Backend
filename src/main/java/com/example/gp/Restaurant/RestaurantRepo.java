package com.example.gp.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    Restaurant findById(int id);
}
