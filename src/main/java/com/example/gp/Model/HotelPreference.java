package com.example.gp.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
public class HotelPreference {
    @Id
    @GeneratedValue
    private int id;

    private String preference;

    @ManyToMany
    @JoinTable(
            name = "user_hotel_preference",
            joinColumns = @JoinColumn(name = "HotelPreference_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> preferencedUsers = new HashSet<>();

    public String getPreference() {
        return preference;
    }

    public Set<User> getPreferencedUsers() {
        return preferencedUsers;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
    public void addPreferencedUser(User user){
        this.preferencedUsers.add(user);
    }
}
