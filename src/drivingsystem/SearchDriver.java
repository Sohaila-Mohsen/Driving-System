package drivingsystem;

public class SearchDriver {
	DB db;
	
	SearchDriver()
	{
		db=DB.getDatabase();
	}
	
	public Driver  searchDriver(int id ) 
	{
        for (int i = 0; i < db.getDrivers().size(); i++) {
           Driver d = db.getDrivers().get(i);
           if(d.getId() == id)
           {  return d;}
      }
        return null;
    }
	
	public AbstractUser searchDriver(String phone) {
    	for (int i = 0; i < db.getDrivers().size(); i++) {
    		if(phone==db.getDrivers().get(i).mobileNumber) {
    			return db.getDrivers().get(i);
    		}
    	}

		return null;
    }
	
	public Driver  searchPennding(int id ) {
        for (int i = 0; i < db.getPending().size(); i++) {
           Driver d = db.getPending().get(i);
           if(d.id == id)
               return d;
      }
        return null;
    }
	
	
	public AbstractUser searchPending(String phone) {
		for (int i = 0; i < db.getPending().size(); i++) {
			if(phone==db.getPending().get(i).mobileNumber) {
				return db.getPending().get(i);
			}
		}
		return null;
    }
	
	 
	
}
