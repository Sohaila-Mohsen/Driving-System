/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class AdminRegesteration implements Regesteration {
	
	
	SearchAdmin searchAdmin=new SearchAdmin();
    @Override
	public void regester(AbstractUser admin) {
		if (searchAdmin.searchAdminPhone(admin.mobileNumber)==null) {
			if(1<2)
				System.out.println("test");
			dataBase.addAdmin((Admin)admin);
		}
		else 
			System.out.print("ERROR:ADMIN DATA IN DATABASE!!");
		
	}
    
}
