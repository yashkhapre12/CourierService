package com.example.CourierRESTAPI.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.CourierRESTAPI.entities.User;
import com.example.CourierRESTAPI.repos.UserRepository;
import com.example.CourierRESTAPI.services.dto.LoginResponse;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	 public User createUser(User user) {
	        return userRepository.save(user);
	    }
	 
	
	
	 public LoginResponse loginUser(String email, String password) {
	     User user = userRepository.findByemail(email)
	         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

	     if (!user.getPassword().equals(password)) {
	         throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
	     }

	     return new LoginResponse(user.getId(), user.getName(), user.getRole().toString());
	 }


	 
	
	 public User getUserByemail(String email) {
		 return userRepository.findByemail(email).orElseThrow(null);
	 }
	 
	 public User getUserById(Long id) {
		 return userRepository.findById(id).orElseThrow(null);
			
	 }
}
