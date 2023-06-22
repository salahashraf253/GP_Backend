package com.example.gp.User;


import com.example.gp.Hotel.Preference.HotelPreferenceService;
import com.example.gp.Restaurant.Cuisine.RestaurantCuisineService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;
    private HotelPreferenceService hotelPreferenceService;
    private RestaurantCuisineService restaurantCuisinesService;

    public UserService(UserRepo userRepo, HotelPreferenceService hotelPreferenceService, RestaurantCuisineService restaurantCuisinesService) {
        this.userRepo = userRepo;
        this.hotelPreferenceService = hotelPreferenceService;
        this.restaurantCuisinesService = restaurantCuisinesService;
    }

    public User getUser(int userId) {
        return userRepo.findById(userId);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User findById(int id) {
        return userRepo.findById(id);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public User login(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    public void deleteUser(long userId) {
        userRepo.deleteById(userId);
    }

    public User editUser(User user) {
        return userRepo.save(user);
    }
}
