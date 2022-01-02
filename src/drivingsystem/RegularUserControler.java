/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

/**
 *
 * @author kingston
 */
public class RegularUserControler  {
    RegularUser R;

    public RegularUserControler(RegularUser R) {
        this.R = R;
    }
    
    public void requestRide(String source, String des){
        RideDetails currentRide = new RideDetails();
        currentRide.setSource(source);
        currentRide.setDestnation(des);
        currentRide.setUser(R);
        R.setCurrentRide(currentRide);
        System.out.println("done 1 source : "+R.getCurrentRide().getSource() + " des : "+R.getCurrentRide().getDestnation() );
        R.DataBase.addRequested(R.getCurrentRide());
    }
    
    public void update(String message) {
         System.out.println(message);
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
