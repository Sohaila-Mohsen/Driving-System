/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

import javax.jws.WebService;

/**
 *
 * @author DELL
 */
@WebService
public class UserNotification implements Notification{
     private String message ;
    private int rideId ;
    SearchDriver searchDriver=new SearchDriver();
    
    public UserNotification( float price ,int rideId , int driverId) {
        this.rideId = rideId;     
        message ="Driver #"+driverId+" with rating "+searchDriver.searchDriver(driverId).getRating().getAvrege()+"$ suggested "+price+ "$ for ride # "+rideId;
    }

    @Override
    public void notifyAllObservers() {
        int size =  dataBase.getRequestedRides().size();
         for (int i = 0; i < size ; i++) {
            RideDetails get = dataBase.getRequestedRides().get(i);
            RegularUserControler u = null;
            if(get.getRideId()== rideId ){
                get.getUser().getConroler().update(message);//maybe cause a problem
                }
            }      
        }
    }

