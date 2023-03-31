package com.example.gp.Hotel.Recommender;

import com.example.gp.Hotel.Hotel;
import com.example.gp.Hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hotels/recommender")
public class HotelRecommender {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/{userId}/{city}")
    public List<Hotel> recommendHotel(@PathVariable int userId,@PathVariable String city){
//        String recommededHotels=getRecommendedHotels(userId,city);
//        System.out.println("===========================");
//        System.out.println(recommededHotels);
//        recommededHotels=recommededHotels.replace("[","");
//        recommededHotels=recommededHotels.replace("]","");
////        recommededHotels=recommededHotels.replace(" ","");
//        String[] arr=recommededHotels.split(",");
//
//        List<Integer>lst=new ArrayList<>();
//        int ctr=0;
//        int n=arr.length;
//        for (String s: arr) {
//            if(ctr == n-2){
//                break;
//            }
//            ctr++;
//            System.out.println(s);
//            System.out.println(s.length());
//            lst.add(Integer.parseInt(s));
//        }
        return hotelService.getAllHotelsById(getRecommendedHotels(userId,city));
    }
//
//    private String getRecommendedHotels(int userId,String city){
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        //this is the response from flask
//        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
//
//        String url = "http://127.0.0.1:5000/hotel/"+ userId + "/" +city ;
//
//        String requestBody = "{}";
//        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//        String response = restTemplate.postForObject(url, entity, String.class);
////        System.out.println(response);
//        return response;
//    }



    private Integer[] getRecommendedHotels(int userId,String city){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String url = "http://127.0.0.1:5000/hotel/"+ userId + "/" +city ;
        ResponseEntity<Integer[]> response = restTemplate.getForEntity(url, Integer[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to get recommended Hotels");
        }
    }
}
