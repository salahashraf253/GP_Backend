package com.example.gp.Restaurant.Cuisine;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table
public class RestaurantCuisine implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("cuisine")
    private String cuisine;

    public String getCuisine() {
        return cuisine;
    }
}
