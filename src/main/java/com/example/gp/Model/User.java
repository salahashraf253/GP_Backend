package com.example.gp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.NonNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String nationality;
    private String phoneNumber;

    @ManyToMany(mappedBy = "preferencedUsers")
    @JsonProperty("hotelPreferences")
    private Set<HotelPreference> hotelPreferences;

    public User(){
        hotelPreferences=new HashSet<>();
    }
    //NOTE: DON'T remove the getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<HotelPreference> getHotelPreferences() {
        return hotelPreferences;
    }

    public void setHotelPreferences(Set<HotelPreference> hotelPreferences) {
        this.hotelPreferences = hotelPreferences;
    }

    public void addHotelPreference(HotelPreference hotelPreference){
        this.hotelPreferences.add(hotelPreference);
    }
}
