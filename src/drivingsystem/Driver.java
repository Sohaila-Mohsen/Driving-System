/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

import java.util.ArrayList;
import javax.jws.WebService;

/**
 *
 * @author DELL
 */
@WebService
public class Driver extends AbstractUser {
    private String licence;
    private String nationalId;
    protected ArrayList <String> favoriteArea ;
    private  ArrayList<String> notifications;
    private DriverStatue statue;
    private boolean isBusy = false;
    private boolean logedIn = false;
    private Rating rating ;
    private RideDetails currentRide  ;
    SearchRide searchRide=new SearchRide();
    protected DriverControler controler;
    
	
	
    public Driver() {
        controler = new DriverControler(this);
        this.favoriteArea = new ArrayList<>();
        notifications = new ArrayList<>();
        this.rating = new Rating();
        id++;
    }

    
    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public boolean IsBusy() {
        return isBusy;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }
    

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public ArrayList<String> getFavoriteArea() {
        return favoriteArea;
    }

    public void addFavoriteArea(String Area) {
        this.favoriteArea.add(Area);
    }

    public DriverStatue getStatue() {
        return statue;
    }

    public void setStatue(DriverStatue statue) {
        this.statue = statue;
    }

    
    
    public void listRatings() {
        rating.listRating();
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public RideDetails getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(RideDetails currentRide) {
        this.currentRide = currentRide;
    }
    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }
    public void addNotification(String notification) {
        this.notifications.add(notification);
    }

    public boolean isLogedIn() {
        return logedIn;
    }

    public void setLogedIn(boolean logedIn) {
        this.logedIn = logedIn;
    }

    public DriverControler getControler() {
        return controler;
    }

    public void setControler(DriverControler controler) {
        this.controler = controler;
    }
    
   
}
