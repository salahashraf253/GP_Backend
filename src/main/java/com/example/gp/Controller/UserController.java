package com.example.gp.Controller;

import com.example.gp.Model.HotelPreference;
import com.example.gp.Model.User;
import com.example.gp.Service.HotelPreferenceService;
import com.example.gp.Service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @JsonProperty("hotelPreferences")
    private List<Integer> hotels;
    private UserService userService;
    private HotelPreferenceService hotelPreferenceService;

    @Autowired
    public UserController(UserService userService, HotelPreferenceService hotelPreferenceService){
        this.userService=userService;
        this.hotelPreferenceService=hotelPreferenceService;
        this.hotels=new ArrayList<>();
    }

    @PostMapping()
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

//    @PutMapping("/{userId}/hotelPreferences/{hotelPreference}")
//    public User addHotelPreferences(@PathVariable int userId,@PathVariable String hotelPreference  )  {
//        return userService.addHotelPreference(userId,hotelPreference);
//    }
}
