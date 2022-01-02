package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class RedularUserRegestration implements Regesteration {
	SearchRUser searchRUser=new SearchRUser();
	
	@Override
	public void regester(AbstractUser regular) {
	    	
		if (searchRUser.searchRegularUser(regular.mobileNumber)==null) {
			dataBase.addRuser(regular);
		}
		else 
			System.out.print("ERROR:USER DATA IN DATABASE!!");	        		
	}
}
