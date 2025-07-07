package com.example.CourierRESTAPI.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
  

    // Constructors
    public User() {}

    public User(String name, String email, String password, String role, String city) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
   
    }


}
