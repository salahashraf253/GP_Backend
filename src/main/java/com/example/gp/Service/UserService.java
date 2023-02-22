package com.example.gp.Service;


import com.example.gp.Model.HotelPreference;
import com.example.gp.Model.User;
import com.example.gp.Repository.HotelPreferenceRepo;
import com.example.gp.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;
    private HotelPreferenceRepo hotelPreferenceRepo;

    public UserService(UserRepo userRepo,HotelPreferenceRepo hotelPreferenceRepo) {
        this.userRepo = userRepo;
        this.hotelPreferenceRepo=hotelPreferenceRepo;
    }

    public User getUser(int userId){
        return userRepo.findById(userId);
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User findById(int id){
        return userRepo.findById(id);
    }

//    private User updateUser(User user){
//        return userRepo.save(user);
//    }

//    @Transactional
//    @Modifying
//    @Query( value = "insert into user_hotel_preference values (:hotelPreferenceId, :userId)",nativeQuery = true)

    public User addHotelPreference(/*@Param("userId")*/ int userId, /*@Param("hotelPreferenceId") */int hotelPreferenceId){
        try{
            User user=userRepo.findById(userId);
            HotelPreference hotelPreference=hotelPreferenceRepo.findById(hotelPreferenceId);

            hotelPreference.addPreferencedUser(user);
            hotelPreferenceRepo.save(hotelPreference);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return userRepo.findById(userId);
    }

//    public User addHotelPreference(User user, HotelPreference hotelPreference){
//        user.addHotelPreference(hotelPreference);
//        return  updateUser(user);
//    }
}
