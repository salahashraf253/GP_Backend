package com.example.gp.User;

import com.example.gp.Hotel.Preference.HotelPreference;
import com.example.gp.Hotel.Preference.HotelPreferenceService;
import com.example.gp.ResourceNotFoundException;
import com.example.gp.Restaurant.Cuisine.RestaurantCuisine;
import com.example.gp.Restaurant.Cuisine.RestaurantCuisineService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private HotelPreferenceService hotelPreferenceService;
    private RestaurantCuisineService restaurantCuisineService;

    public UserController(UserService userService, HotelPreferenceService hotelPreferenceService, RestaurantCuisineService restaurantCuisineService) {
        this.userService = userService;
        this.hotelPreferenceService = hotelPreferenceService;
        this.restaurantCuisineService = restaurantCuisineService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
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

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}/hotels/preferences/{hotelPreferenceId}")
    public User assignHotelPreference(@PathVariable int userId, @PathVariable int hotelPreferenceId) {
        User user = userService.findById(userId);
        HotelPreference hotelPreference = hotelPreferenceService.findById(hotelPreferenceId);
        user.addHotelPreference(hotelPreference);
        return userService.save(user);
    }

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

}
