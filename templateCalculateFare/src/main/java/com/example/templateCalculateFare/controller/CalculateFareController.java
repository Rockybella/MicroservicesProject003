package com.example.templateCalculateFare.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.templateCalculateFare.model.FareRequest;

@RestController
public class CalculateFareController {

    @Value("${app.calculatefare}")
    private String calculateFareGreeting;

    @Value("${app.fare}")
    private int defaultBaseFare;

    @PostMapping("/calculateFare")
    public ResponseEntity<Double> calculateFare(@RequestBody FareRequest fareRequest) {
        System.out.println(calculateFareGreeting);

        // Set the dynamic base fare
        int dynamicBaseFare = fareRequest.getBaseFare() != null ? fareRequest.getBaseFare() : defaultBaseFare;

        // Calculate fare based on the user-entered distance
        double fare = calculateFareBetweenLocations(fareRequest.getDistance(), dynamicBaseFare);
        return new ResponseEntity<>(fare, HttpStatus.OK);
    }

    // Method to calculate fare based on entered distance
    private double calculateFareBetweenLocations(double distance, int baseFare) {
        double perMileRate = 1.5;  // Example rate per mile
        return baseFare + (perMileRate * distance);  // Calculate fare
    }
}
