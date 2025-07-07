package com.example.CourierRESTAPI.services.dto;


import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CourierResponseDto {
    private Long id;
    private String senderName;
    private String receiverName;
    private String pickupAddress;
    private String deliveryAddress;
    private Double weight;
    private String status;
    private LocalDateTime createdAt;

    // Getters and Setters
}
