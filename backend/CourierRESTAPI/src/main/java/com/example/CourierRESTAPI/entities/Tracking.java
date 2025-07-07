package com.example.CourierRESTAPI.entities;



import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currentLocation;

    private String remarks;

    private String statusUpdate; // e.g., "Out for delivery"

    @CreationTimestamp
    private LocalDateTime updatedTime;

    @OneToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    // Getters and Setters
}

