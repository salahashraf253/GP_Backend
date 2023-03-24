package com.example.gp.Hotel;

import com.example.gp.Hotel.Preference.HotelPreference;
import com.example.gp.User.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/hotels/recommender")
public class HotelRecommenderController {

    public HotelRecommenderController(){

    }

    @PostMapping("")
    public void recommendHotel(){
        RestTemplate restTemplate = new RestTemplate();

        User data = new User();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> requestEntity = new HttpEntity<>(data, headers);

        String url = "http://127.0.0.1:5000/hotel";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

        String responseBody = responseEntity.getBody();
        System.out.println(responseBody);
    }

}
