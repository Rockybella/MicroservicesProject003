package com.example.templateBookingCabMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties
@Entity
public class Cab {

    @JsonProperty
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cabID;

    @JsonProperty("fromLocation")
    private String fromLocation;

    @JsonProperty("toLocation")
    private String toLocation;

    @JsonProperty("typeOfCab")
    private Integer typeOfCab;

    @JsonProperty("rate")
    private Double rate;

    @JsonProperty("distance")
    private Double distance;  // Field for distance

    @JsonProperty("totalFare")
    private Double totalFare; // Field for total fare

    public Cab() {
        super();
    }

    public Cab(Integer cabID, String fromLocation, String toLocation, Integer typeOfCab, Double rate, Double distance, Double totalFare) {
        this.cabID = cabID;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.typeOfCab = typeOfCab;
        this.rate = rate;
        this.distance = distance;
        this.totalFare = totalFare;
    }

    // Getters and setters for each field
    public Integer getCabID() {
        return cabID;
    }

    public void setCabID(Integer cabID) {
        this.cabID = cabID;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Integer getTypeOfCab() {
        return typeOfCab;
    }

    public void setTypeOfCab(Integer typeOfCab) {
        this.typeOfCab = typeOfCab;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Double totalFare) {
        this.totalFare = totalFare;
    }

    @Override
    public String toString() {
        return "Cab [cabID=" + cabID + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + 
               ", typeOfCab=" + typeOfCab + ", rate=" + rate + ", distance=" + distance + ", totalFare=" + totalFare + "]";
    }
}
