/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivingsystem.src.drivingsystem;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class RideDetails {
        private static int Id = 0;
        private int rideId ;
	private RegularUser user ;
	private Driver  driver;
	private String source ;
	private String destnation ;
        private int numOfPassengers;
        private Event event;
	private ArrayList<Offer> suggestedPrices;
	private float price;
        private boolean isActive;
	SearchDriver searchDriver=new SearchDriver();
        
    public RideDetails(){
        rideId = ++Id;
        suggestedPrices = new ArrayList<>();
        event = new Event(this);
    }    
    
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public static int getId() {
        return Id;
    }

    public static void setId(int Id) {
        RideDetails.Id = Id;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public ArrayList<Offer> getSuggestedPrices() {
        return suggestedPrices;
    }

    public void setSuggestedPrices(ArrayList<Offer> suggestedPrices) {
        this.suggestedPrices = suggestedPrices;
    }

    public SearchDriver getSearchDriver() {
        return searchDriver;
    }

    public void setSearchDriver(SearchDriver searchDriver) {
        this.searchDriver = searchDriver;
    }
    
    
    public RegularUser getUser() {
        return user;
    }

    public void setUser(RegularUser User) {
        this.user = User;
    }

    public boolean IsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestnation() {
        return destnation;
    }

    public void setDestnation(String destnation) {
        this.destnation = destnation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    
    public void listSuggested() {
        Offer o;
	for (int i = 0; i < suggestedPrices.size(); i++) {
            o = suggestedPrices.get(i);
            System.out.println("Driver #"+o.driverId+" suggested "+o.price+"$");
        }	
    }
    public Offer searchSuggested(int Id){
        for (int i = 0; i < suggestedPrices.size(); i++) {
            if(suggestedPrices.get(i).driverId==Id)
                return suggestedPrices.get(i);
        }
        return null;
    }
    public int hasDiscount(){
        //discunt areas
        int discount = 0;
        for (int i = 0; i < DB.getDatabase().getDiscountAreas().size(); i++) {
            String get = DB.getDatabase().getDiscountAreas().get(i);
            if(get.equalsIgnoreCase(destnation))
                discount+= 10;     
        }
        //birthday gift
        LocalDate dateOfBirth = user.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(),dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        if (currentMonthDay.equals(birthday)) 
            discount+= 10;
        if(numOfPassengers==2)
            discount+= 5;
        
        boolean first = true;
        for (int i = 0; i < DB.getDatabase().getRequestedRides().size(); i++) {
            RideDetails get =  DB.getDatabase().getRequestedRides().get(i);
            if(user.getId()==get.getUser().getId()){
                first = false;
                break;
            }     
        }
        if(first)
            discount+= 10;
        
        return discount;
    }
    public void addPrice(float price, int driverID) {
        Offer o = new Offer() ;
        o.driverId = driverID;
        o.price = price;
        suggestedPrices.add(o);
        UserNotification un = new UserNotification(price, rideId , driverID);
        un.notifyAllObservers();
	
    }
    
}
