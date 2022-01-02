/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SW2_Project.drivingsystem.src.drivingsystem;

/**
 *
 * @author DELL
 */
public class DriverNotification implements Notification{
    private String message ;
    private String source ;
    private int numOfPassenger;

    public DriverNotification( String source ,String destination,int id,int numOfPassenger) {
        message ="User #"+id+" reruested ride from "+source+" to "+destination+" with "+numOfPassenger+" Passenger";
        this.source = source;
        this.numOfPassenger = numOfPassenger;
    }

    @Override
    public void notifyAllObservers() {
        int size =  dataBase.getDrivers().size();
        for (int i = 0; i < size ; i++) {
            Driver get = dataBase.getDrivers().get(i);
            if(get.getCurrentRide()!= null){
                for(int j=0 ; j<get.getFavoriteArea().size() ; j++)
                {
                    if(get.getFavoriteArea().get(j).equalsIgnoreCase( source ) ){
                        get.controler.update(message);//maybe make a problem
                    }
            }   }      
        }
    }
    
}
