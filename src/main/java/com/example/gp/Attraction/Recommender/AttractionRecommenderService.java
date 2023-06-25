package com.example.gp.Attraction.Recommender;

import com.example.gp.Recommender;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class AttractionRecommenderService extends Recommender {

    public AttractionRecommenderService(){
        this.usedUrl = baseUrl + "/attraction";
    }
    @Override
    public Integer[] recommend(int userId, String city) {
        // usedUrl += "/" + city;
        String url = usedUrl + "/" + userId + "/" + city;
        ResponseEntity<Integer[]> response = restTemplate.getForEntity(url, Integer[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to get recommended Attractions");
        }
    }


    // @Override
    // public void userProfile(int userId, int [] userPreferences){
    //     url += "/user-profile/" + userId;
    //     System.out.println("URL: " + url);
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
        
    //     HttpEntity<int[]> requestEntity = new HttpEntity<>(userPreferences, headers);

    //     RestTemplate restTemplate = new RestTemplate();
    //     ResponseEntity<String> response = restTemplate.exchange(
    //             url,
    //             HttpMethod.POST,
    //             requestEntity,
    //             String.class
    //     );

    //     String userProfile = response.getBody();
        
    //     System.out.println("AttractionUser Profile: " + userProfile);

    // }
}
