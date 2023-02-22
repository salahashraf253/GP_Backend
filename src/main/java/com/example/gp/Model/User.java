package com.example.gp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "name_id",referencedColumnName = "id")
    @JsonProperty("name")
    private Name name;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String password;


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
    public Name getName(){
        return name;
    }
}
