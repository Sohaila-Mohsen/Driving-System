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
    private ArrayList <String> favoriteArea ;
    private DriverStatue statue;
    private Rating rating ;
    private String currentRide ;


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

    public void listPossibleRides() {
        for (int i = 0; i < DataBase.getRequestedRides().size(); i++) {
            for(int j=0 ; j<favoriteArea.size();j++){
                if ( DataBase.getRequestedRides().get(i).getSource()==favoriteArea.get(i))
                    System.out.print("User #"+DataBase.getRequestedRides().get(i).getUser().id+" reruested ride from "+DataBase.getRequestedRides().get(i).getSource());
                  System.out.println(" to "+DataBase.getRequestedRides().get(i).getDestnation());
            }
        }
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

    public void register(Driver driver){

    }
    //////////take Ride///////////
	
//	 public void takeRide()
//	 { 
//		 DataBase.listRides();
//		 System.out.println("Enter suggested price");
//	 }
	 

public void suggestPrice(int rideId , float price){
    if(DataBase.searchRequstedRides(rideId) != null )
            DataBase.searchRequstedRides(rideId).addPrice(price, rideId);
    else
        System.out.println("Ride is no lonnger available");
}
public void update (String message){
    System.out.println(message);
}





}
