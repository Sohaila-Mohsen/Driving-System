/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SW2_Project.drivingsystem.src.drivingsystem;

/**
 *
 * @author DELL
 */
public class Admin extends AbstractUser{
	
	SearchDriver searchDriver=new SearchDriver();
	SearchRUser searchRUser=new SearchRUser();
        static AdminControler controler;

    public Admin() {
        this.controler = new AdminControler(this);
    }
        
	
    void register(Admin admin) {
        
    }


    public AdminControler getControler() {
        return controler;
    }

    
}
