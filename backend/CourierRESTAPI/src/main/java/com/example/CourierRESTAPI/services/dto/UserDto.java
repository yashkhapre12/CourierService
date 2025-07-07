package com.example.CourierRESTAPI.services.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String role;
    private String city;
    private boolean approved;

    public UserDto() {}

    public UserDto(Long id, String name, String role, String city, boolean approved) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.city = city;
        this.approved = approved;
    }

    // Getters and Setters
    // ...
}
