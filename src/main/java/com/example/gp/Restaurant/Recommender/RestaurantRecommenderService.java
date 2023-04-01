package com.example.gp.Restaurant.Recommender;

import com.example.gp.Recommender;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRecommenderService extends Recommender {
    @Override
    public Integer[] recommend(int userId, String city) {
        return new Integer[0];
    }
}
