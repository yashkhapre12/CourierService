package com.example.CourierRESTAPI.services.dto;

import lombok.Data;

@Data
public class LoginRequest {
	
	private String email;
	private String password;
	
}
