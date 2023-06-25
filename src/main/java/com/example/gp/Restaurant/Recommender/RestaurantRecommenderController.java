package com.example.gp.Restaurant.Recommender;

import com.example.gp.Restaurant.Restaurant;
import com.example.gp.Restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restaurants/recommender")
public class RestaurantRecommenderController {
    @Autowired
    private RestaurantRecommenderService restaurantRecommenderService;
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{userId}/{city}")
    public List<Restaurant> recommendRestaurant(@PathVariable int userId, @PathVariable String city) {
        Integer[] recommendedRestaurantId = restaurantRecommenderService.recommend(userId, city);
        return restaurantService.getAllRestaurantsById(recommendedRestaurantId);
    }

    @GetMapping("/cosine/{userId}")
    public List<Restaurant> recommendRestaurantByCosine(@PathVariable int userId) {
        Integer[] recommendedRestaurantId = restaurantRecommenderService.recommendByCosineSimilarity(userId);
        return restaurantService.getAllRestaurantsById(recommendedRestaurantId);
    }
}
