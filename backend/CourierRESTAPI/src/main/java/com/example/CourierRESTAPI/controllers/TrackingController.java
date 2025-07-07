package com.example.CourierRESTAPI.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.CourierRESTAPI.entities.Courier;
import com.example.CourierRESTAPI.entities.Tracking;
import com.example.CourierRESTAPI.services.CourierService;
import com.example.CourierRESTAPI.services.TrackingService;
import com.example.CourierRESTAPI.services.dto.TrackingDto;

@RestController
@RequestMapping("/api/tracking")
@CrossOrigin
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @Autowired
    private CourierService courierService;

    @PostMapping("/add")
    public TrackingDto createTracking(@RequestBody TrackingDto dto) {
        Courier courier = courierService.getCourierById(dto.getCourierId());

        Tracking tracking = new Tracking();
        tracking.setCourier(courier);
        tracking.setCurrentLocation(dto.getCurrentLocation());
        tracking.setRemarks(dto.getRemarks());
        tracking.setStatusUpdate(dto.getStatusUpdate());

        Tracking saved = trackingService.createTracking(tracking);
        return mapToDto(saved);
    }

    @GetMapping("/courier/{courierId}")
    public TrackingDto getTracking(@PathVariable Long courierId) throws Exception {
        return mapToDto(trackingService.getTrackingByCourierId(courierId));
    }

    private TrackingDto mapToDto(Tracking t) {
        TrackingDto dto = new TrackingDto();
        dto.setCourierId(t.getCourier().getId());
        dto.setCurrentLocation(t.getCurrentLocation());
        dto.setRemarks(t.getRemarks());
        dto.setStatusUpdate(t.getStatusUpdate());
        dto.setUpdatedTime(t.getUpdatedTime());
        return dto;
    }
}

