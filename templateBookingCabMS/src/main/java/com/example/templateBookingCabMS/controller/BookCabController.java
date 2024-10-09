package com.example.templateBookingCabMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.templateBookingCabMS.model.Cab;
import com.example.templateBookingCabMS.service.CabService;

@RestController
@Configuration
@RequestMapping(path = "cab")
@CrossOrigin(origins = "http://localhost:4200") //This is for Angular
public class BookCabController {

    @Autowired
    private CabService cabService;

    @Value("${app.greeting}")
    private String testGreeting;

    // Retrieve all booked cabs
    @GetMapping("/all")
    public ResponseEntity<List<Cab>> getAllCabs() {
        List<Cab> allCabsList = cabService.getAllBookedCabs();
        return ResponseEntity.ok(allCabsList);
    }

    // Add a booked cab with fare calculation
    @PostMapping("/add")
    public ResponseEntity<Cab> addBookedCab(@RequestBody Cab cab) {
        // Ensure that distance is retrieved from the Cab object
        double distance = cab.getDistance();
        
        // Use the provided rate instead of calculating it from the microservice
        double rate = cab.getRate(); // Retrieve the rate from the Cab object
        
        // Calculate the total fare using the provided rate and distance
        double totalFare = rate * distance; // Assuming fare calculation logic is rate * distance

        // Set the calculated total fare in the Cab object
        cab.setTotalFare(totalFare);

        // Save the cab to the database
        Cab cabBookedToDB = cabService.bookCab(cab);

        return ResponseEntity.status(HttpStatus.CREATED).body(cabBookedToDB);
    }

    // Another endpoint to add a booked cab (used for extended functionality)
    @PostMapping("/addtwo")
    public ResponseEntity<Cab> addBookedCabtwo(@RequestBody Cab cab) {
        double distance = cab.getDistance();  // Get distance from the Cab object
        double rate = cab.getRate(); // Retrieve the rate from the Cab object

        // Calculate the total fare using the provided rate and distance
        double totalFare = rate * distance; // Assuming fare calculation logic is rate * distance

        // Set the calculated total fare and distance to the Cab object
        cab.setTotalFare(totalFare);
        cab.setDistance(distance);

        // Save the cab to the database
        Cab cabBookedToDB = cabService.bookCab(cab);

        return ResponseEntity.status(HttpStatus.CREATED).body(cabBookedToDB);
    }
}
