/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

/**
 *
 * @author DELL
 */
public class RegularUser extends AbstractUser {
 
    private RideDetails currentRide ;
    private UserStatue statue;
    SearchDriver searchDriver=new SearchDriver();
  

    public UserStatue getStatue() {
        return statue;
    }

    public void setStatue(UserStatue statue) {
        this.statue = statue;
    }
    
    public void requestRide(String source, String des){
        currentRide = new RideDetails();
        currentRide.setSource(source);
        currentRide.setDestnation(des);
        currentRide.setUser(this);
        DataBase.addRequested(currentRide);
    }

    public void update(String message) {
         System.out.println(message);
    }

    public void rate (int driverId , float rate) {
        Driver d = searchDriver.searchDriver(driverId);
        if(d==null)
            System.out.println("Driver not Found");
        else{
	        if(rate >=1 && rate<=5){
	           d.getRating().addRating(rate, this.getId());
	        }
	        else
	            System.out.println("Rating Must Be between 1 and 5 ");
        }

    }
}
