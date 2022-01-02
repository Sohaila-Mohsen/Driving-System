/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SW2_Project.drivingsystem.src.drivingsystem;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class RegularUser extends AbstractUser {
 
    protected RideDetails currentRide ;
    protected boolean logedin;
    private  ArrayList<String> notifications;
    private UserStatue statue;
    private SearchDriver searchDriver =new SearchDriver();
    private static RegularUserControler conroler;

    public RegularUser() {
        this.conroler = new RegularUserControler(this);
        notifications = new ArrayList<>();
    }
  
    

    public UserStatue getStatue() {
        return statue;
    }

    public void setStatue(UserStatue statue) {
        this.statue = statue;
    }

    public RideDetails getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(RideDetails currentRide) {
        this.currentRide = currentRide;
    }

    public SearchDriver getSearchDriver() {
        return searchDriver;
    }

    public void setSearchDriver(SearchDriver searchDriver) {
        this.searchDriver = searchDriver;
    }

    public boolean isLogedin() {
        return logedin;
    }

    public void setLogedin(boolean logedin) {
        this.logedin = logedin;
    }
    
    public static RegularUserControler getConroler() {
        return conroler;
    }

    public void setConroler(RegularUserControler conroler) {
        this.conroler = conroler;
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
    
}
