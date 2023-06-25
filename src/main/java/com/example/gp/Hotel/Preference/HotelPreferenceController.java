package com.example.gp.Hotel.Preference;

import com.example.gp.User.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels/preferences")
public class HotelPreferenceController {
    private HotelPreferenceService hotelPreferenceService;
    private UserService userService;

    public HotelPreferenceController(HotelPreferenceService hotelPreferenceService, UserService userService) {
        this.hotelPreferenceService = hotelPreferenceService;
        this.userService = userService;
    }

    @GetMapping()
    public List<HotelPreference> getHotelPreferences() {
        return hotelPreferenceService.findAll();
    }

    // @PostMapping()
    // public void addHotelPreference(@RequestBody HotelPreference hotelPreference) {
    //     this.hotelPreferenceService.save(hotelPreference);
    // }

    @PostMapping()
    public void addHotelPreference(@RequestBody List<HotelPreference> hotelPreferences) {
        this.hotelPreferenceService.addHotelPreferences(hotelPreferences);
    }


    /*@PutMapping("/{userId}/{hotelPreferenceId}")
    public User addHotelPreferenceToUser(@PathVariable int userId, @PathVariable int hotelPreferenceId) {
        User user = userService.findById(userId);
        HotelPreference hotelPreference = hotelPreferenceService.findById(hotelPreferenceId);
        user.addHotelPreference(hotelPreference);
        return userService.save(user);
    }*/

}
