package com.example.gp.Hotel.Recommender;

import com.example.gp.Recommender;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HotelRecommenderService extends Recommender {

    public HotelRecommenderService() {
        this.usedUrl = baseUrl + "/hotel";
    }

    @Override
    public Integer[] recommend(int userId, String city) {
        // usedUrl += "/"+ userId + "/" + city;
        String url = usedUrl + "/" + userId + "/" + city;
        ResponseEntity<Integer[]> response = restTemplate.getForEntity(url, Integer[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to get recommended Hotels");
        }
    }

    // @Override
    // public void userProfile(int userId, int [] userPreferences){
    // url += "/user-profile/" + userId;
    // System.out.println("URL: " + url);
    // HttpHeaders headers = new HttpHeaders();
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // HttpEntity<int[]> requestEntity = new HttpEntity<>(userPreferences, headers);

    // RestTemplate restTemplate = new RestTemplate();
    // ResponseEntity<String> response = restTemplate.exchange(
    // url,
    // HttpMethod.POST,
    // requestEntity,
    // String.class
    // );
    // String userProfile = response.getBody();
    // System.out.println("Hotel User Profile: " + userProfile);
    // }
}
