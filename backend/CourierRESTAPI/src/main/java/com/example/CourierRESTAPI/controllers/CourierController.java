package com.example.CourierRESTAPI.controllers;




import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourierRESTAPI.entities.Courier;
import com.example.CourierRESTAPI.entities.User;
import com.example.CourierRESTAPI.services.CourierService;
import com.example.CourierRESTAPI.services.UserService;
import com.example.CourierRESTAPI.services.dto.CourierRequestDto;
import com.example.CourierRESTAPI.services.dto.CourierResponseDto;

@RestController
@RequestMapping("/api/couriers")
@CrossOrigin
public class CourierController {

    @Autowired
    private CourierService courierService;

    @Autowired
    private UserService userService;

    @PostMapping("/book")
    public CourierResponseDto bookCourier(@RequestBody CourierRequestDto dto) {
        User sender = userService.getUserById(dto.getSenderId());

        Courier courier = new Courier();
        courier.setSender(sender);
        courier.setReceiverName(dto.getReceiverName());
        courier.setPickupAddress(dto.getPickupAddress());
        courier.setDeliveryAddress(dto.getDeliveryAddress());
        courier.setWeight(dto.getWeight());

        Courier saved = courierService.bookCourier(courier);

        return mapToDto(saved);
    }

    @GetMapping("/{id}")
    public CourierResponseDto getCourier(@PathVariable Long id) {
        Courier courier = courierService.getCourierById(id);
        return mapToDto(courier);
    }

    @GetMapping("/user/{userId}")
    public List<CourierResponseDto> getUserCouriers(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return courierService.getCouriersByUser(user)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private CourierResponseDto mapToDto(Courier courier) {
        CourierResponseDto dto = new CourierResponseDto();
        dto.setId(courier.getId());
        dto.setSenderName(courier.getSender().getName());
        dto.setReceiverName(courier.getReceiverName());
        dto.setPickupAddress(courier.getPickupAddress());
        dto.setDeliveryAddress(courier.getDeliveryAddress());
        dto.setWeight(courier.getWeight());
        dto.setStatus(courier.getStatus());
        dto.setCreatedAt(courier.getCreatedAt());
        return dto;
    }
}
