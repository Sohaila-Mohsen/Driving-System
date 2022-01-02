package drivingsystem;

import javax.jws.WebService;

@WebService
public class SearchRUser {

	DB db;
	SearchRUser()
	{
		db=DB.getDatabase();
	}
	
	public AbstractUser searchRegularUser(String phone) {
    	for (int i = 0; i < db.getRegularUsers().size(); i++) {
    		if(phone==db.getRegularUsers().get(i).mobileNumber) {
    			return db.getRegularUsers().get(i);
    		}
    	}
    	return null;
    }
	
	public RegularUser searchUser(int id){
        for(int i=0 ; i<db.getRegularUsers().size() ; i++)
        {
            if(db.getRegularUsers().get(i).id == id){
                return db.getRegularUsers().get(i) ;
            }
        }
        return null;
    }
    
	
	public boolean searchRegularUser(AbstractUser regular) {
    	for (int i = 0; i < db.getRegularUsers().size(); i++) {
    		if(regular.mobileNumber==db.getRegularUsers().get(i).mobileNumber) {
    			return true;
    		}
    	}

		return false;
    }
	
	public AbstractUser searchUser(String monbileNumber, String pass){
        for(int i=0 ; i<db.getRegularUsers().size() ; i++)
        {
            if(db.getRegularUsers().get(i).mobileNumber.equalsIgnoreCase(monbileNumber) && db.getRegularUsers().get(i).password.equalsIgnoreCase(pass)){
                return db.getRegularUsers().get(i) ;
            }
        }
        return null;
    }

}
