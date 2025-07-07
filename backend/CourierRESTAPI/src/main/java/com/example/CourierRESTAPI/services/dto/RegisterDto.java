package com.example.CourierRESTAPI.services.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String email;
    private String password;
    private String role; // CUSTOMER, ADMIN, HUB
    private String city; // Optional for CUSTOMER, required for HUB

   

 
}
