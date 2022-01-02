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
public class DriverControler  {
    Driver D ;

    public DriverControler(Driver D) {
        this.D=D;
    }
            
   
    public void listPossibleRides() {
        for (int i = 0; i < D.DataBase.getRequestedRides().size(); i++) {
            for(int j=0 ; j<D.favoriteArea.size();j++){
                if ( D.DataBase.getRequestedRides().get(i).getSource().equalsIgnoreCase(D.getFavoriteArea().get(i))){
                  System.out.print("User #"+D.DataBase.getRequestedRides().get(i).getUser().id+" reruested ride # "+D.DataBase.getRequestedRides().get(i).getRideId());
                  System.out.println(" from "+D.DataBase.getRequestedRides().get(i).getSource() +" to "+D.DataBase.getRequestedRides().get(i).getDestnation());}
            }
        }
    }
    
     public void suggestPrice(int rideId , float price){
        if(D.searchRide.searchRequstedRides(rideId) != null )
                D.searchRide.searchRequstedRides(rideId).addPrice(price,D.getId());
        else
            System.out.println("Ride is no lonnger available");
    }
     
    public void update (String message){
        System.out.println(message);
    }
}
