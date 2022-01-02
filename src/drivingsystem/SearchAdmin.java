package drivingsystem;

import javax.jws.WebService;

@WebService
public class SearchAdmin {

	DB db;
	SearchAdmin()
	{
		db=DB.getDatabase();
	}
	
	
	public AbstractUser searchAdminPhone(String phone) {
    	for (int i = 0; i < db.getAdmins().size(); i++) {
    		if(phone==db.getAdmins().get(i).mobileNumber) {
    			return db.getAdmins().get(i);
    		}
    	}
		return null;
    }
}
