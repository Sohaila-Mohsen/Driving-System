/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class Admin extends AbstractUser{
	
	SearchDriver searchDriver=new SearchDriver();
	SearchRUser searchRUser=new SearchRUser();
        static AdminControler controler;

    public Admin() {
        this.controler = new AdminControler(this);
    }
        
	
    void register(Admin admin) {
        
    }

    
}
