package com.example.gp.Attraction.Recommender;

import com.example.gp.Recommender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AttractionRecommenderService extends Recommender {

    @Override
    public Integer[] recommend(int userId, String city) {
        String url = baseUrl + "/attraction/" + userId + "/" + city;
        ResponseEntity<Integer[]> response = restTemplate.getForEntity(url, Integer[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to get recommended Attractions");
        }
    }
}
