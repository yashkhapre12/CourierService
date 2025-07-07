package com.example.CourierRESTAPI.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourierRESTAPI.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findByemail(String email);
}
