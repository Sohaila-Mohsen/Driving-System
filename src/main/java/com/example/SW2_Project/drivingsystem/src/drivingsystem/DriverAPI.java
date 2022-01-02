package com.example.SW2_Project.drivingsystem.src.drivingsystem;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverAPI {

    @PostMapping("/Driver/ListPossibleRides/{mobile}")
    ArrayList<String> ListPossibleRides(@PathVariable String mobile){
        ArrayList<String> Arr  = new ArrayList<>(); 
        String s;
       if(SearchDriver.searchDriver(mobile)==null){
            s ="Driver Not Found";
            Arr.add(s);
            return Arr;
        }
        else if (SearchAdmin.searchAdminPhone(mobile).isLogedIn()){
            Driver d =(Driver) SearchAdmin.searchAdminPhone(mobile);
            return d.getControler().ListRides();
        }
        else{
            s = "Login First";
            Arr.add(s);
            return Arr;
        }
    }
    @PostMapping("/Driver/suggestOffer/{mobile}/{rideID}/{price}")
    String suggestOffer(@PathVariable String mobile, @PathVariable int rideID , @PathVariable float price){
        if(SearchDriver.searchDriver(mobile)==null){
            return "Driver Not Found";
        }
        else if (SearchAdmin.searchAdminPhone(mobile).isLogedIn()){
            Driver d =(Driver) SearchAdmin.searchAdminPhone(mobile);
            return d.controler.suggestPrice(rideID, price);
        }
        else{
            return "Login First";
        }
        
    }

    @PostMapping("/Driver/AddFavoriteArea/{mobile}/{place}")
    String AddFavoriteArea(@PathVariable String mobile,@PathVariable String place){
        if(SearchDriver.searchDriver(mobile)==null){
            return "Driver Not Found";
        }
        else if (SearchAdmin.searchAdminPhone(mobile).isLogedIn()){
            Driver d =(Driver) SearchAdmin.searchAdminPhone(mobile);
            d.addFavoriteArea(place);
            return "Area Added Successfuly";
        }
        else{
            return "Login First";
        }
    }

    @PostMapping("/Driver/StartRide/{mobile}")
    String StartRide(@PathVariable String mobile){
        if(SearchDriver.searchDriver(mobile)==null){
            return "Driver Not Found";
        }
        else if (SearchAdmin.searchAdminPhone(mobile).isLogedIn()){
            Driver d =(Driver) SearchAdmin.searchAdminPhone(mobile);
            return d.controler.startRide();
        }
        else{
            return "Login First";
        }
    }
    @PostMapping("/Driver/EndRide/{mobile}")
    String EndRide(@PathVariable String mobile){
        if(SearchDriver.searchDriver(mobile)==null){
            return "Driver Not Found";
        }
        else if (SearchAdmin.searchAdminPhone(mobile).isLogedIn()){
            Driver d =(Driver) SearchAdmin.searchAdminPhone(mobile);
            return d.controler.endRide();
        }
        else{
            return "Login First";
        }
    }

    @PostMapping("/Driver/ListNotification/{mobile}")
    ArrayList<String> ListNotification(@PathVariable String mobile){
        ArrayList<String> Arr  = new ArrayList<>(); 
        String s;
        if(SearchDriver.searchDriver(mobile)==null){
            s= "Driver Not Found";
            Arr.add(s);
            return Arr;
        }
        else if (SearchAdmin.searchAdminPhone(mobile).isLogedIn()){
            Driver d =(Driver) SearchAdmin.searchAdminPhone(mobile);
            return d.controler.listNotification();
        }
        else{
            s= "Login First";
            Arr.add(s);
            return Arr;
        }
    }
    
}
