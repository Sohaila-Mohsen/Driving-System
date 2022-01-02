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
 
    protected RideDetails currentRide ;
    private UserStatue statue;
    private SearchDriver searchDriver =new SearchDriver();
    private RegularUserControler conroler;

    public RegularUser() {
        this.conroler = new RegularUserControler(this);
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

    public RegularUserControler getConroler() {
        return conroler;
    }

    public void setConroler(RegularUserControler conroler) {
        this.conroler = conroler;
    }
    
    
    
}
