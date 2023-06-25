package com.example.gp.Attraction.Recommender;

import com.example.gp.Recommender;


import org.springframework.stereotype.Service;


@Service
public class AttractionRecommenderService extends Recommender {

    public AttractionRecommenderService(){
        this.usedUrl = baseUrl + "/attraction";
    }

}
