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
public class UserNotification implements Notification{
     private String message ;
    private int rideId ;

    public UserNotification( float price ,int rideId , int driverId) {
        this.rideId = rideId;     
        message ="Driver #"+driverId+" with rating "+dataBase.searchDriver(driverId).getRating().getAvrege()+"$ suggested "+price+ "$ for ride # "+rideId;
    }

    @Override
    public void notifyAllObservers() {
        int size =  dataBase.getRequestedRides().size();
         for (int i = 0; i < size ; i++) {
            RideDetails get = dataBase.getRequestedRides().get(i);
            if(get.getRideId()== rideId ){
                get.getUser().update(message);
                }
            }      
        }
    }

