package com.example.CourierRESTAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourierRESTAPI.entities.User;
import com.example.CourierRESTAPI.services.UserService;
import com.example.CourierRESTAPI.services.dto.LoginRequest;
import com.example.CourierRESTAPI.services.dto.LoginResponse;
import com.example.CourierRESTAPI.services.dto.UserDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
	    LoginResponse response = userService.loginUser(request.getEmail(), request.getPassword());
	    return ResponseEntity.ok(response);
	}

	
	@PostMapping("/register")
    public UserDto registerUser(@RequestBody User user) {
        User saved = userService.createUser(user);
        return new UserDto(saved.getId(), saved.getName(), saved.getEmail(), saved.getRole());
    }

	@GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
	
}
