package com.example.CourierRESTAPI.entities;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiverName;

    private String pickupAddress;
    private String deliveryAddress;

    private Double weight;

    private String status; // e.g., "BOOKED", "IN_TRANSIT", "DELIVERED"

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private CourierStatus statuss;

    
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @OneToOne(mappedBy = "courier", cascade = CascadeType.ALL)
    private Tracking tracking;

    // Getters and Setters
}
