package com.example.gp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class Recommender {
    @Autowired
    public RestTemplate restTemplate;

    public String baseUrl;

    public Recommender(){
        this.baseUrl="http://127.0.0.1:5000";
    }

    public abstract Integer[] recommend(int userId, String city);
}
