/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivingsystem.src.drivingsystem;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class RegularUserControler  {
    RegularUser R;

    public RegularUserControler(RegularUser R) {
        this.R = R;
    }
    
    public void requestRide(String source, String des ,int numOfPassenger){
        RideDetails currentRide = new RideDetails();
        currentRide.setSource(source);
        currentRide.setDestnation(des);
        currentRide.setUser(R);
        currentRide.setNumOfPassengers(numOfPassenger);
        R.setCurrentRide(currentRide);
        R.DataBase.addRequested(R.getCurrentRide());
        System.out.println("done 1 source : "+R.getCurrentRide().getSource() + " des : "+R.getCurrentRide().getDestnation() );
    }
    
    public boolean acceptOffer (int ID){
        Driver d = SearchDriver.searchDriver(ID);
        if(R.getCurrentRide().searchSuggested(ID)!=null && !d.IsBusy()){
            System.out.println("here");
            R.getCurrentRide().setDriver(d);
            R.getCurrentRide().getEvent().setCaptain(d);
            R.getCurrentRide().getEvent().setEventName(EventType.OfferAccepted);
            Date eventTime = (Date) java.util.Calendar.getInstance().getTime();
            R.getCurrentRide().getEvent().setEventTime(eventTime);
            R.getCurrentRide().getEvent().setPrice(R.getCurrentRide().searchSuggested(ID).price);
            R.getCurrentRide().setPrice(R.getCurrentRide().searchSuggested(ID).price);
            R.getCurrentRide().getEvent().setUser(R);
            Event event = R.getCurrentRide().getEvent();
            DB.getDatabase().addEvent(event);
            R.getCurrentRide().getDriver().setCurrentRide(R.getCurrentRide());
            d.setCurrentRide(R.getCurrentRide());
            return true;     
        }
            return false;
    }
    public void update(String message) {
        if(R.isLogedin())
            System.out.println(message);
        else
            R.addNotification(message);
    }
    public void showNotification( ) {
        for (int i = 0; i < R.getNotifications().size(); i++) {
            String get = R.getNotifications().get(i);
            System.out.println(i+". "+get); 
        }
        for (int i = 0; i < R.getNotifications().size(); i++) {
            R.getNotifications().remove(i);
        }
    }
    public void rate (int driverId , float rate) {
        Driver d = R.getSearchDriver().searchDriver(driverId);
        if(d==null)
            System.out.println("Driver not Found");
        else{
        if(rate >=1 && rate<=5){
           d.getRating().addRating(rate, R.getId());
        }
        else
            System.out.println("Rating Must Be between 1 and 5 ");
        }

    }

}
