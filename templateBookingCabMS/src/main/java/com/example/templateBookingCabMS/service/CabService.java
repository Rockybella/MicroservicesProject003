package com.example.templateBookingCabMS.service;

import java.util.List;
import java.util.Optional;

import com.example.templateBookingCabMS.model.Cab;

public interface CabService {
    
    // Method to book a cab and save it to the database
    Cab bookCab(Cab cab);
    
    // Method to retrieve a cab by its ID
    Optional<Cab> getCabById(Integer id);
    
    // Method to retrieve all booked cabs
    List<Cab> getAllBookedCabs();
    
    // Method to delete a cab by its ID
    void deleteCab(Integer id);
}
