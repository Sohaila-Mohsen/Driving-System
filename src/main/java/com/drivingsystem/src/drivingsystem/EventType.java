/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public enum EventType {
    PriceSuggested,OfferAccepted,DriverArived,RideEnded ;
    @Override
    public String toString(){
        switch (this){
            case PriceSuggested : return "Price Suggested";
            case OfferAccepted : return "Offer Accepted";
            case DriverArived : return "Driver Arived to Location";
            case RideEnded : return "Ride Ended";
            default:return "No Event";
        }
    }
    
}
