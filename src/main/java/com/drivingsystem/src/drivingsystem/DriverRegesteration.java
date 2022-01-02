/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class DriverRegesteration implements Regesteration {
	
	SearchDriver searchDriver=new SearchDriver();
	
    @Override
    public void regester(AbstractUser driver){
    	
		if (searchDriver.searchDriver(driver.mobileNumber)==null && searchDriver.searchPending(driver.mobileNumber)==null) {
			dataBase.addPending(driver);
		}
		else 
			System.out.print("ERROR:DRIVER DATA IN DATABASE!!");
		
	}
}
