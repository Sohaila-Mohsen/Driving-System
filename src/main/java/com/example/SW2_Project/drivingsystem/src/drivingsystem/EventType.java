/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SW2_Project.drivingsystem.src.drivingsystem;
/**
 *
 * @author DELL
 */
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
