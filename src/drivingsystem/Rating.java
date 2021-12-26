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
