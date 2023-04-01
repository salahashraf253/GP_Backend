package com.example.gp.User;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Builder
@Data
public class UserDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String secondName;

    @Email
    private String email;

    @NotEmpty
    private String nationality;

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;

    public UserDTO(String firstName, String secondName, String email, String nationality, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.nationality = nationality;
        this.password = password;
    }
    public UserDTO(){

    }

    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .email(user.getEmail())
                .nationality(user.getNationality())
                .build();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO get() {
        return this;
    }
}
