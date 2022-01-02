package com.drivingsystem.src.drivingsystem;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class Rating {  
    private ArrayList <Rate> ratings;
    private float avregeRaiting ;

    public Rating() {
        this.avregeRaiting = 0;
    }
    
    void listRating() {
        for (int i = 0; i < ratings.size(); i++) {
            Rate get = ratings.get(i);
            System.out.println("User # "+ get.userId + " rated you with "+get.rate+" stars");         
        }
        
    }
    
    void addRating(float rating , int userId ) {
        Rate r = new Rate();
        r.rate=rating;
        r.userId=userId;
        ratings.add(r);
        updateAvrage(rating);
    
    }
    void updateAvrage(float rating ) {
        avregeRaiting = ((ratings.size()-1) * avregeRaiting) + rating;
        avregeRaiting /= ratings.size();
    }
    float getAvrege() {
        return avregeRaiting;
    } 

    }
