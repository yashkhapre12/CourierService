package com.example.CourierRESTAPI.services.dto;

import lombok.Data;

@Data
public class CourierRequestDto {
    private Long senderId;

    private String receiverName;
    private String pickupAddress;
    private String deliveryAddress;
    private Double weight;

    // Getters and Setters
}
