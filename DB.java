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
public class DB {
    private ArrayList <Driver> drivers ;
    private ArrayList <Driver> pending;
    private ArrayList <RegularUser> regularUsers;
    private ArrayList <Admin> admin;
    private ArrayList <RideDetails> requestedRides;
    private static DB Database;

    public static synchronized DB getDatabase() {
        if(Database == null)
            Database = new DB();
        return Database;
    }
    public AbstractUser searchUser(String monbileNumber, String pass){
        
    }
    public void  addDriver(Driver driver ) {

    }
    public void addRuser(RegularUser rUser){

    }
    public void addAdmin (Admin admin){

    }
    public void removePending(Driver driver){

    }

    public void addPending() {

    }
    public void listDrivers() {

    } 
    public void listRuser(){

    }
    public void addRide(){

    }
    public void addRequested(RideDetails requsted  ) {

    } 
    private DB() {
        }

    
}
