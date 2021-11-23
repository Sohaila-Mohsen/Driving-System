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
    private ArrayList <Admin> admins;
    private ArrayList <RideDetails> requestedRides;
    private static DB Database;

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Driver> getPending() {
        return pending;
    }

    public void setPending(ArrayList<Driver> pending) {
        this.pending = pending;
    }

    public ArrayList<RegularUser> getRegularUsers() {
        return regularUsers;
    }

    public void setRegularUsers(ArrayList<RegularUser> regularUsers) {
        this.regularUsers = regularUsers;
    }

    public ArrayList<Admin> getAdmin() {
        return admins;
    }

    public void setAdmin(ArrayList<Admin> admin) {
        admins = admin;
    }

    public ArrayList<RideDetails> getRequestedRides() {
        return requestedRides;
    }

    public void setRequestedRides(ArrayList<RideDetails> requestedRides) {
        this.requestedRides = requestedRides;
    }
    
    public static synchronized DB getDatabase() {
        if(Database == null)
            Database = new DB();
        return Database;
    }
    public AbstractUser searchUser(String monbileNumber, String pass){
        for(int i=0 ; i<regularUsers.size() ; i++)
        {
            if(regularUsers.get(i).mobileNumber.equalsIgnoreCase(monbileNumber) && regularUsers.get(i).password.equalsIgnoreCase(pass)){
                return regularUsers.get(i) ;
            }
        }
        return null;
    }

    public RegularUser searchUser(int id){
        for(int i=0 ; i<regularUsers.size() ; i++)
        {
            if(regularUsers.get(i).id == id){
                return regularUsers.get(i) ;
            }
        }
        return null;
    }
    public Driver  searchDriver(int id ) {
         for (int i = 0; i < drivers.size(); i++) {
            Driver d = drivers.get(i);
            if(d.id == id)
                return d;
       }
         return null;
    }
    public Driver  searchPennding(int id ) {
         for (int i = 0; i < pending.size(); i++) {
            Driver d = pending.get(i);
            if(d.id == id)
                return d;
       }
         return null;
    }
    
    public RideDetails  searchRequstedRides(int id ) {
         for (int i = 0; i < requestedRides.size(); i++) {
            RideDetails rd = requestedRides.get(i);
            if(rd.getRideId() == id)
                return rd;
       }
         return null;
    }
    public void addRuser(RegularUser rUser){
        regularUsers.add(rUser);
    }
    public void addAdmin (Admin admin){
        admins.add(admin);
    }
    public void removePending(Driver driver){
        drivers.remove(driver);
    }

    public void addPending(Driver driver) {
        pending.add(driver);

    }
    public void  addDriver(Driver driver ) {
        drivers.add(driver);
    }
    public void listDrivers() {
        for (int i = 0; i < drivers.size(); i++) {
            Driver d = drivers.get(i);
            System.out.println("Driver # "+d.id+"\n"+d.name+"\nWith avrege Rating = "+d.getRating().getAvrege()+" star");     
        }

    } 
    public void listRuser(){
        for (int i = 0; i < regularUsers.size(); i++) {
            RegularUser r = regularUsers.get(i);
            System.out.println("User # "+r.id+"\n"+r.name);     
        }
    }
    public void listPendding(){
        for (int i = 0; i < pending.size(); i++) {
            Driver d = pending.get(i);
            System.out.println("Driver # "+d.id+"\n"+d.name);
        }
    }
    public void addRide(RideDetails confirmed){
        for(int i = 0; i < requestedRides.size(); i++) {
            if(confirmed.equals(requestedRides.get(i)))
                requestedRides.remove(i);
        }
    }
    public void addRequested(RideDetails requsted ) {
        requestedRides.add(requsted);
    } 
    private DB() {
        }

    
}
