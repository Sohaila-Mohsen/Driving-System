package com.example.SW2_Project.drivingsystem.src.drivingsystem;
import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RegularUserAPI {
    @PostMapping("/user/RequestDrive/{mobile}/{source}/{des}/{num}")
    String RequestDrive(@PathVariable String mobile ,@PathVariable String source , @PathVariable String des , @PathVariable int num )
    {
        if(SearchRUser.searchRegularUser(mobile)==null)
        return "User Not Found";
        else if (SearchRUser.searchRegularUser(mobile).isLogedIn()){
            RegularUser U = (RegularUser) SearchRUser.searchRegularUser(mobile);
            U.getConroler().requestRide(source,des,num);
            return "Ride Requested Sucssfuly ";
        }
        else
        return "Login First";
    }

    @PostMapping("/user/ListOffers/{mobile}")  
    ArrayList<String> ListOffers(@PathVariable String mobile){
        ArrayList<String> Arr  = new ArrayList<>(); 
        String s;
        if(SearchRUser.searchRegularUser(mobile)==null){
            s ="User Not Found";
            Arr.add(s);
            return Arr;
        }
        else if (SearchRUser.searchRegularUser(mobile).isLogedIn()){
            RegularUser U = (RegularUser) SearchRUser.searchRegularUser(mobile);
            return U.getConroler().ListSuggested();
        }
        else{
            s = "Login First";
            Arr.add(s);
            return Arr;
        }
        
    }
    @PostMapping("/user/ShowNotification/{mobile}")  
    ArrayList<String> ShowNotification(@PathVariable String mobile){
        ArrayList<String> Arr  = new ArrayList<>(); 
        String s;
        if(SearchRUser.searchRegularUser(mobile)==null){
            s ="User Not Found";
            Arr.add(s);
            return Arr;
        }
        else if (SearchRUser.searchRegularUser(mobile).isLogedIn()){
            RegularUser U = (RegularUser) SearchRUser.searchRegularUser(mobile);
            return U.getConroler().ListNotification();
        }
        else{
            s = "Login First";
            Arr.add(s);
            return Arr;
        }

    }

    @PostMapping("/user/acceptOffer/{mobile}/{id}")  
    String acceptOffer(@PathVariable String mobile,@PathVariable int id){
        String s;
        if(SearchRUser.searchRegularUser(mobile)==null){
            return "User Not Found";
        }
        else if (SearchRUser.searchRegularUser(mobile).isLogedIn()){
            RegularUser U = (RegularUser) SearchRUser.searchRegularUser(mobile);
            if( U.getConroler().acceptOffer(id))
                return "Offer Accepted Successfuly";
            else
                return "Offer Not Found";
        }
        else{
            return "Login First";
        }
    }

    @PostMapping("/user/rateDriver/{mobile}/{driverId}/{rate}")  
    String rateDriver(@PathVariable String mobile,@PathVariable int driverId,@PathVariable float rate){
        String s;
        if(SearchRUser.searchRegularUser(mobile)==null){
            return "User Not Found";
        }
        else if (SearchRUser.searchRegularUser(mobile).isLogedIn()){
            RegularUser U = (RegularUser) SearchRUser.searchRegularUser(mobile);
                return U.getConroler().rateDriver(driverId, rate);
        }
        else{
            return "Login First";
        }
    }

}
//((RegularUser)U).getConroler().rate(driverId, rate)