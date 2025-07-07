package com.example.CourierRESTAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourierRESTAPI.entities.Tracking;
import com.example.CourierRESTAPI.repos.TrackingRepository;

@Service
public class TrackingService {

	@Autowired
	private TrackingRepository trackingRepository;
	
	public Tracking createTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }
	
	public Tracking getTrackingByCourierId(Long CourierId) throws Exception {
		Tracking tracking = trackingRepository.findByCourierId(CourierId);
		if (tracking == null) {
			throw new Exception("not found sorry");
		}
		return tracking;
	}
	
	public Tracking updateTracking(Long trackingId, String location, String remarks,String statusUpdate) {
		Tracking tracking = trackingRepository.findById(trackingId).get();
		tracking.setCurrentLocation(location);
		tracking.setRemarks(remarks);
		tracking.setStatusUpdate(statusUpdate);
		return trackingRepository.save(tracking);
	}
}
