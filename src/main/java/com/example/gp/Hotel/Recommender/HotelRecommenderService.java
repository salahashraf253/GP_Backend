package com.example.gp.Hotel.Recommender;

import com.example.gp.Recommender;


import org.springframework.stereotype.Service;

@Service
public class HotelRecommenderService extends Recommender {

    public HotelRecommenderService() {
        this.usedUrl = baseUrl + "/hotel";
    }

}
