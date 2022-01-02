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
public class Driver extends AbstractUser {
    private String licence;
    private String nationalId;
    protected ArrayList <String> favoriteArea ;
    private DriverStatue statue;
    private Rating rating ;
    private String currentRide ;
    SearchRide searchRide=new SearchRide();
    protected DriverControler controler;
    
	
	
    public Driver() {
        controler = new DriverControler(this);
        this.favoriteArea = new ArrayList<>();
        this.rating = new Rating();
        id++;
    }

    
    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
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

    public String getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(String currentRide) {
        this.currentRide = currentRide;
    }

   
}
