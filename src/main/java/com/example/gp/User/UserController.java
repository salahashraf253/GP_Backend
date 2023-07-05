package com.example.gp.User;

import com.example.gp.Hotel.Recommender.HotelRecommenderService;
import com.example.gp.Hotel.Preference.HotelPreferenceService;
import com.example.gp.ResourceNotFoundException;
import com.example.gp.Attraction.Preference.AttractionPreferenceService;
import com.example.gp.Attraction.Recommender.AttractionRecommenderService;
import com.example.gp.Restaurant.Cuisine.RestaurantCuisineService;
import com.example.gp.Restaurant.Recommender.RestaurantRecommenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private HotelPreferenceService hotelPreferenceService;
    private RestaurantCuisineService restaurantCuisineService;
    private AttractionPreferenceService attractionPreferenceService;
    @Autowired
    private AttractionRecommenderService attractionRecommenderService;
    @Autowired
    private HotelRecommenderService hotelRecommenderService;
    @Autowired
    private RestaurantRecommenderService restaurantRecommenderService;

    public UserController(UserService userService, HotelPreferenceService hotelPreferenceService, RestaurantCuisineService restaurantCuisineService, AttractionPreferenceService attractionPreferenceService) {
        this.userService = userService;
        this.hotelPreferenceService = hotelPreferenceService;
        this.restaurantCuisineService = restaurantCuisineService;
        this.attractionPreferenceService=attractionPreferenceService;
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> mp) {
        System.out.println("Email: " + mp.get("email"));
        User user = userService.login(mp.get("email"), mp.get("password"));
        if (user == null) {
            //wrong email or password
            throw new ResourceNotFoundException();
        }
        return user;
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{userId}")
    public User editUser(@PathVariable int userId,@RequestBody User user) {
        return userService.editUser(userId,user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    // @PutMapping("/{userId}/hotels/preferences/{hotelPreferenceId}")
    // public User assignHotelPreference(@PathVariable int userId, @PathVariable int hotelPreferenceId) {
    //     User user = userService.findById(userId);
    //     HotelPreference hotelPreference = hotelPreferenceService.findById(hotelPreferenceId);
    //     user.addHotelPreference(hotelPreference);
    //     return userService.save(user);
    // }

//    @PutMapping("/{userId}/restaurants/cuisines/{cuisineId}")
//    public User assignRestaurantCuisine(@PathVariable int userId, @PathVariable int cuisineId) {
//        User user = userService.findById(userId);
//        RestaurantCuisine restaurantCuisine = restaurantCuisineService.findById(cuisineId);
//        user.getRestaurantCuisine(restaurantCuisine);
//        return userService.save(user);
//    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/preferences/{userId}")
    public User addPreference(@PathVariable int userId, @RequestBody HashMap<String, int []> mp) {
        User user = userService.findById(userId);
        int [] hotelPreferences = mp.get("hotelPreferences");
        int [] restaurantCuisines = mp.get("restaurantCuisines");
        int [] attractionPreferences = mp.get("attractionPreferences");

        for (int i = 0; i < hotelPreferences.length; i++) {
            user.addHotelPreference(hotelPreferenceService.findById(hotelPreferences[i]));
        }
        for (int i = 0; i < restaurantCuisines.length; i++) {
            user.addRestaurantCuisine(restaurantCuisineService.findById(restaurantCuisines[i]));
        }
        for(int i=0;i<attractionPreferences.length;i++){
            user.addAttractionPreference(attractionPreferenceService.findById(attractionPreferences[i]));
        }

        //user profile 
        attractionRecommenderService.userProfile(userId, attractionPreferences);
        hotelRecommenderService.userProfile(userId, attractionPreferences);
        restaurantRecommenderService.userProfile(userId, attractionPreferences);
        return userService.save(user);
    }

    // @GetMapping("/recommender/plan/{userId}/{city}")
    // public Map<String, Object> getPlan(@PathVariable int userId, @PathVariable String city) {

    // }

}
