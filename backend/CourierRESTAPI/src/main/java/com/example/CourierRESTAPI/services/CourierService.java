package com.example.CourierRESTAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourierRESTAPI.entities.Courier;
import com.example.CourierRESTAPI.entities.User;
import com.example.CourierRESTAPI.repos.CourierRepository;

@Service
public class CourierService {
	 @Autowired
	 private CourierRepository courierRepository;
	 
	 public Courier bookCourier(Courier courier) {
		courier.setStatus("Booked");
		return courierRepository.save(courier);
	 }
	 
	 public Courier getCourierById(Long id) {
		 return courierRepository.findById(id).get();
	 }
	 
	 public List<Courier> getAllCouriers() {
	        return courierRepository.findAll();
	    }
	 
	 public List<Courier> getCouriersByUser(User user) {
	        return courierRepository.findBySender(user);
	    }
}
