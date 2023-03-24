package com.example.gp.User;

import com.example.gp.Hotel.Preference.HotelPreference;
import com.example.gp.Restaurant.Cuisine.RestaurantCuisine;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String firstName;

    private String secondName;

    private String nationality;

    private String phoneNumber;

    private String email;

    private String password;


    @ManyToMany
    @JoinTable(
            name = "hotelPreferences_Likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "HotelPreference_id")
    )
    private Set<HotelPreference> hotelPreferencesLikes;

    @ManyToMany
    @JoinTable(
            name = "RestaurantCuisines_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "RestaurantCuisines_id")
    )
    private Set<RestaurantCuisine> restaurantCuisinesLikes;

    public User() {
    }

    public String getNationality() {
        return nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Set<HotelPreference> getHotelPreferencesLikes() {
        return hotelPreferencesLikes;
    }

    public void setHotelPreferencesLikes(Set<HotelPreference> hotelPreferencesLikes) {
        this.hotelPreferencesLikes = hotelPreferencesLikes;
    }

    public Set<RestaurantCuisine> getRestaurantCuisinesLikes() {
        return restaurantCuisinesLikes;
    }

    public void setRestaurantCuisinesLikes(Set<RestaurantCuisine> restaurantCuisinesLikes) {
        this.restaurantCuisinesLikes = restaurantCuisinesLikes;
    }


    public void addHotelPreference(HotelPreference hotelPreference) {
        this.hotelPreferencesLikes.add(hotelPreference);
    }

    public void getRestaurantCuisine(RestaurantCuisine restaurantCuisine) {
        this.restaurantCuisinesLikes.add(restaurantCuisine);
    }
}
