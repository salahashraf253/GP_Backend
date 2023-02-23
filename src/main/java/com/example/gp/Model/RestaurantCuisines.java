package com.example.gp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class RestaurantCuisines implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("cuisine")
    private String cuisine;

    public String getCuisine() {
        return cuisine;
    }
}
