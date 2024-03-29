package com.example.gp.User;

import com.example.gp.Attraction.Preference.AttractionPreference;
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


    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("secondName")
    private String secondName;

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
    private Set<HotelPreference> hotelPreferencesLikes;

    @ManyToMany
    @JoinTable(
            name = "RestaurantCuisines_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "RestaurantCuisines_id")
    )
    private Set<RestaurantCuisine> restaurantCuisinesLikes;

    @ManyToMany
    @JoinTable(
            name = "attracionPreferences_Likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "AttractionPreference_id")
    )
    private Set<AttractionPreference> attractionPreferencesLikes;

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

    public void addRestaurantCuisine(RestaurantCuisine restaurantCuisine) {
        this.restaurantCuisinesLikes.add(restaurantCuisine);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addAttractionPreference(AttractionPreference attractionPreference) {
        this.attractionPreferencesLikes.add(attractionPreference);
    }

    public Set<AttractionPreference> getAttractionPreferencesLikes() {
        return attractionPreferencesLikes;
    }

    public void setAttractionPreferencesLikes(Set<AttractionPreference> attractionPreferencesLikes) {
        this.attractionPreferencesLikes = attractionPreferencesLikes;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }   
}
