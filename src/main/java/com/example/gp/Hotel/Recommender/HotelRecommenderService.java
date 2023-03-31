package com.example.gp.Hotel.Recommender;

import com.example.gp.Recommender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HotelRecommenderService extends Recommender {

    @Override
    public Integer[] recommend(int userId, String city) {
        String url = baseUrl + "/hotel/" + userId + "/" + city;
        ResponseEntity<Integer[]> response = restTemplate.getForEntity(url, Integer[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to get recommended Hotels");
        }
    }
}
