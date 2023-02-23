package com.example.gp.User;


import com.example.gp.Hotel.Preference.HotelPreferenceService;
import com.example.gp.Restaurant.Cuisine.RestaurantCuisineService;
import com.example.gp.User.Name.Name;
import com.example.gp.User.Name.NameService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;
    private HotelPreferenceService hotelPreferenceService;
    private NameService nameService;
    private RestaurantCuisineService restaurantCuisinesService;

    public UserService(UserRepo userRepo, HotelPreferenceService hotelPreferenceService, NameService nameService, RestaurantCuisineService restaurantCuisinesService) {
        this.userRepo = userRepo;
        this.hotelPreferenceService = hotelPreferenceService;
        this.nameService = nameService;
        this.restaurantCuisinesService = restaurantCuisinesService;
    }

    public User getUser(int userId) {
        return userRepo.findById(userId);
    }

    public User addUser(User user) {
        Name name = user.getName();
        nameService.save(name);
//        Set<HotelPreference> hotelPreference = user.getHotelPreferencesLikes();
//        hotelPreferenceRepo.saveAll(hotelPreference);
//        Set<RestaurantCuisine> restaurantCuisines = user.getRestaurantCuisinesLikes();
//        restaurantCuisinesService.addCuisines(restaurantCuisines);
        return userRepo.save(user);
    }

    public User findById(int id) {
        return userRepo.findById(id);
    }

    public User save(User user) {
        return userRepo.save(user);
    }


}
