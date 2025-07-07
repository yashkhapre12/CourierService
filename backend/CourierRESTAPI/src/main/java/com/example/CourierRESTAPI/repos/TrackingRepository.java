package com.example.CourierRESTAPI.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourierRESTAPI.entities.Tracking;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
	Tracking findByCourierId(Long courierId);
}
