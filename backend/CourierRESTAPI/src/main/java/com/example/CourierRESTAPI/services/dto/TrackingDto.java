package com.example.CourierRESTAPI.services.dto;


import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TrackingDto {
    private Long courierId;
    private String currentLocation;
    private String remarks;
    private String statusUpdate;
    private LocalDateTime updatedTime;

    // Getters and Setters
}
