package com.example.CourierRESTAPI.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourierRESTAPI.entities.Courier;
import com.example.CourierRESTAPI.entities.Tracking;
import com.example.CourierRESTAPI.entities.User;

public interface CourierRepository extends JpaRepository<Courier, Long> {
	List<Courier> findBySender(User sender); 
}
