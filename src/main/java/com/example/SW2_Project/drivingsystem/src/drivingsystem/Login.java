package com.example.SW2_Project.drivingsystem.src.drivingsystem;

public interface  Login {
	
	DB data=DB.getDatabase();
	public AbstractUser verifyInformation(String phone ,String password);
}
