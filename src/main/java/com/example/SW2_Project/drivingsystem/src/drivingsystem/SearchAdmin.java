package com.example.SW2_Project.drivingsystem.src.drivingsystem;

public class SearchAdmin {

	static DB db;
	SearchAdmin()
	{
		db=DB.getDatabase();
	}
	
	
	public static AbstractUser searchAdminPhone(String phone) {
    	for (int i = 0; i < db.getAdmins().size(); i++) {
    		if(phone==db.getAdmins().get(i).mobileNumber) {
    			return db.getAdmins().get(i);
    		}
    	}
		return null;
    }
}
