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
    
    
    public void register(RegularUser regularUser)//this
    {
        
    }

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
    //public void confirmRide (){
    //  
    //}
    public void rate (int dtiverId , float rate) {
        if(rate >=1 && rate<=5)
            DataBase.searchDriver(id).getRating().addRating(rate, this.id);

    }
}
