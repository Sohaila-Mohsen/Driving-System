package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public interface Notification {
    public DB dataBase = DB.getDatabase();
	public void notifyAllObservers( );	
}
