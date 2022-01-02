package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 

import java.util.Date;

@RestController

public class Event {
    private EventType eventName;
    private Date eventTime;
    private Driver captain;
    private RegularUser user;
    private RideDetails ride;
    private float price;

    public Event(RideDetails R) {
        this.eventTime = new Date();
        this.captain = new Driver();
        this.user = new RegularUser();
        this.ride = R ;
        this.price = -1;
    }

    
    public EventType getEventName() {
        return eventName;
    }

    public void setEventName(EventType eventName) {
        this.eventName = eventName;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Driver getCaptain() {
        return captain;
    }

    public void setCaptain(Driver captain) {
        this.captain = captain;
    }

    public RegularUser getUser() {
        return user;
    }

    public void setUser(RegularUser user) {
        this.user = user;
    }

    public RideDetails getRide() {
        return ride;
    }

    public void setRide(RideDetails ride) {
        this.ride = ride;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
