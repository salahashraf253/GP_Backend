package com.example.gp.User;

import com.example.gp.Hotel.Preference.HotelPreference;
import com.example.gp.Restaurant.Cuisine.RestaurantCuisine;
import com.example.gp.User.Name.Name;
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

    @OneToOne
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    @JsonProperty("name")
    private Name name;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;


    @ManyToMany
    @JoinTable(
            name = "hotelPreferences_Likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "HotelPreference_id")
    )
    @JsonProperty("hotelPreferencesLikes")
    private Set<HotelPreference> hotelPreferencesLikes;

    @ManyToMany
    @JoinTable(
            name = "RestaurantCuisines_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "RestaurantCuisines_id")
    )
    @JsonProperty("restaurantCuisinesLikes")
    private Set<RestaurantCuisine> restaurantCuisinesLikes;

    public User() {
    }

    //NOTE: DON'T remove the getters
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

    public Name getName() {
        return name;
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
