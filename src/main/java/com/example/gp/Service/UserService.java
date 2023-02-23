package com.example.gp.Service;


import com.example.gp.Model.HotelPreference;
import com.example.gp.Model.Name;
import com.example.gp.Model.User;
import com.example.gp.Repository.HotelPreferenceRepo;
import com.example.gp.Repository.NameRepo;
import com.example.gp.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private UserRepo userRepo;
    private HotelPreferenceRepo hotelPreferenceRepo;
    private NameRepo nameRepo;

    public UserService(UserRepo userRepo, HotelPreferenceRepo hotelPreferenceRepo, NameRepo nameRepo) {
        this.userRepo = userRepo;
        this.hotelPreferenceRepo = hotelPreferenceRepo;
        this.nameRepo = nameRepo;
    }

    public User getUser(int userId) {
        return userRepo.findById(userId);
    }

    public User addUser(User user) {
        Name name = user.getName();
        nameRepo.save(name);
        Set<HotelPreference> hotelPreference = user.getHotelPreferencesLikes();
        hotelPreferenceRepo.saveAll(hotelPreference);
        return userRepo.save(user);
    }

    public User findById(int id) {
        return userRepo.findById(id);
    }


}
