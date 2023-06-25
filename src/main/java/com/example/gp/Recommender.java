package com.example.gp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class Recommender {
    @Autowired
    public RestTemplate restTemplate;

    public String baseUrl;
    public String usedUrl;

    public Recommender(){
        this.baseUrl="http://127.0.0.1:5000";
    }

    public abstract Integer[] recommend(int userId, String city);

    public void userProfile(int userId, int [] userPreferences){
        // usedUrl += "/user-profile/" + userId;
        String url = usedUrl + "/user-profile/" + userId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<int[]> requestEntity = new HttpEntity<>(userPreferences, headers);

        ResponseEntity<String> response = this.restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        System.out.println("User Profile: " +response.getStatusCode());
    }
}
