/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public enum DriverStatue {
    PENDING,ACTIVE,SUSPENDED;
    @Override
    public String toString(){
        switch (this){
            case PENDING : return "Pendind";
            case ACTIVE : return "Active";
            case SUSPENDED : return "Suspended";
            default: return "Active";
        }
    }
    DriverStatue(){

    }
        
    
}
