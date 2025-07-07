package com.example.CourierRESTAPI.services.dto;

import lombok.Data;

@Data
public class LoginResponse {

	private Long id;
    private String name;
    private String role;
    
    public LoginResponse(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
}
