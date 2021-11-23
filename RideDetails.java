/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class RideDetails {
        private static int Id = 0;
        private int rideId ;
	private RegularUser user ;
	private Driver  driver;
	private String source ;
	private String destnation ;
	private ArrayList<Offer> suggestedPrices;
	private float price;
	public DB database;
        
    public RideDetails(){
        rideId = ++Id;
        Notification n = new DriverNotification(source , destnation ,user.id);
        n.notifyAllObservers();
    }    
    
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public RegularUser getUser() {
        return user;
    }

    public void setUser(RegularUser User) {
        this.user = User;
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

    public DB getDatabase() {
        return database;
    }

    public void setDatabase(DB database) {
        this.database = database;
    }
	
    public void listSuggested() {
        Offer o;
	for (int i = 0; i < suggestedPrices.size(); i++) {
            o = suggestedPrices.get(i);
            System.out.println("Driver # "+o.driverId+" with rate "+database.searchDriver(o.driverId).getRating().getAvrege()+" suggested "+o.price+"$ for your ride");     
        }	
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
