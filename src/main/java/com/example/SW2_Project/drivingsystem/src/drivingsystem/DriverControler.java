/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SW2_Project.drivingsystem.src.drivingsystem;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kingston
 */
public class DriverControler  {
    Driver D ;

    public DriverControler(Driver D) {
        this.D=D;
    }
            
   
    public void listPossibleRides() {
        System.out.println("size = "+D.DataBase.getRequestedRides().size());
        for (int i = 0; i < D.DataBase.getRequestedRides().size(); i++) {
            for(int j=0 ; j<D.favoriteArea.size();j++){
                if ( D.DataBase.getRequestedRides().get(i).getSource().equalsIgnoreCase(D.getFavoriteArea().get(j))){
                  System.out.print("User #"+D.DataBase.getRequestedRides().get(i).getUser().id+" reruested ride # "+D.DataBase.getRequestedRides().get(i).getRideId());
                  System.out.println(" from "+D.DataBase.getRequestedRides().get(i).getSource() +" to "+D.DataBase.getRequestedRides().get(i).getDestnation());}
            }
        }
    }
    public ArrayList<String> ListRides() {
        ArrayList<String> Arr = new ArrayList<>();
        String s;
        for (int i = 0; i < D.DataBase.getRequestedRides().size(); i++) {
            for(int j=0 ; j<D.favoriteArea.size();j++){
                if ( D.DataBase.getRequestedRides().get(i).getSource().equalsIgnoreCase(D.getFavoriteArea().get(j))){
                  s= "User #"+D.DataBase.getRequestedRides().get(i).getUser().id+" reruested ride # "+D.DataBase.getRequestedRides().get(i).getRideId();
                  s+=" from "+D.DataBase.getRequestedRides().get(i).getSource() +" to "+D.DataBase.getRequestedRides().get(i).getDestnation();
                  Arr.add(s);
                }
            }
        }
        return Arr;
    }
    
     public String suggestPrice(int rideId , float price){
         RideDetails R = D.searchRide.searchRequstedRides(rideId);
        if(R != null ){
            if(R.hasDiscount()!=0)
                R.addPrice((price/100*R.hasDiscount()),D.getId());
            else
                R.addPrice(price,D.getId());
                Date date=java.util.Calendar.getInstance().getTime();    
                R.getEvent().setEventTime(date);
                R.getEvent().setPrice(price);
                R.getEvent().setCaptain(D);
                R.getEvent().setRide(R);
                R.getEvent().setUser(R.getUser());
                R.getEvent().setEventName(EventType.PriceSuggested);
                Event event = R.getEvent();
                DB.getDatabase().addEvent(event);
            return "Price Suggested Siccesfully";
        }
        else
            return "Ride is no lonnger available";
    }
    public String endRide(){
        if(D.getCurrentRide()!=null)
        {
            D.getCurrentRide().setIsActive(false);
            D.setIsBusy(false);
            D.setBalence(D.getBalence()+D.getCurrentRide().getPrice()*100/10-D.getCurrentRide().getPrice());
            D.getCurrentRide().getUser().setCurrentRide(null);
            Date date=java.util.Calendar.getInstance().getTime();    
            D.getCurrentRide().getEvent().setEventTime(date);
            D.getCurrentRide().getEvent().setPrice(D.getCurrentRide().getPrice());
            D.setBalence(D.getBalence()+D.getCurrentRide().getPrice()-D.getCurrentRide().getPrice()*100/hashCode());
            D.getCurrentRide().getEvent().setCaptain(D);
            D.getCurrentRide().getEvent().setRide(D.getCurrentRide());
            D.getCurrentRide().getEvent().setUser(D.getCurrentRide().getUser());
            D.getCurrentRide().getEvent().setEventName(EventType.RideEnded);
            Event event = D.getCurrentRide().getEvent();
            DB.getDatabase().addEvent(event);
            D.setCurrentRide(null);
            return "Thanks for your effort \u2764";
        }
        else
            return "There is no current ride :(";
    }
    public String startRide(){
        if(D.getCurrentRide()!=null)
        {
            D.getCurrentRide().setIsActive(true);
            D.setIsBusy(true);
            D.getCurrentRide().getUser().setCurrentRide(null);
            Date date=java.util.Calendar.getInstance().getTime();    
            D.getCurrentRide().getEvent().setEventTime(date);
            D.getCurrentRide().getEvent().setCaptain(D);
            D.getCurrentRide().getEvent().setRide(D.getCurrentRide());
            D.getCurrentRide().getEvent().setUser(D.getCurrentRide().getUser());
            D.getCurrentRide().getEvent().setEventName(EventType.DriverArived);
            Event event = D.getCurrentRide().getEvent();
            DB.getDatabase().addEvent(event);
            return "Have Nice Ride \u2764";
        }
        else
            return "There is no current ride :(";
        
    }
    public void showBalene(){
        System.out.println("Balence : "+D.getBalence());
    }
    public void update(String message) {
        if(D.isLogedIn())
            System.out.println(message);
        else
            D.addNotification(message);
    }
    public void showNotification( ) {
        for (int i = 0; i < D.getNotifications().size(); i++) {
            String get = D.getNotifications().get(i);
            System.out.println(i+". "+get); 
        }
        for (int i = 0; i < D.getNotifications().size(); i++) {
            D.getNotifications().remove(i);
        }
    }
    public ArrayList<String> listNotification(){
        ArrayList<String> Arr = new ArrayList<>();
        String s;
        for (int i = 0; i < D.getNotifications().size(); i++) {
            String get = D.getNotifications().get(i);
            s=i+". "+get; 
            Arr.add(s);
        }
        for (int i = 0; i < D.getNotifications().size(); i++) {
            D.getNotifications().remove(i);
        }
        return Arr;
    }
    public void addFav(String place){
        addFav(place);
    }
}
