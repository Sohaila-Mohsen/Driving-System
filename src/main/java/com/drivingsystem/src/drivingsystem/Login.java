package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public interface  Login {
	
	DB data=DB.getDatabase();
	public AbstractUser verifyInformation(String phone ,String password);
}
