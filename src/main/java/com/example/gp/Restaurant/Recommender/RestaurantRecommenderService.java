package com.example.gp.Restaurant.Recommender;

import com.example.gp.Recommender;



import org.springframework.stereotype.Service;

@Service
public class RestaurantRecommenderService extends Recommender {

    public RestaurantRecommenderService(){
        this.usedUrl = baseUrl + "/restaurant";
    }

}
