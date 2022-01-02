package drivingsystem;

import javax.jws.WebService;

@WebService
public class SearchRide {

	DB db;
	SearchRide()
	{
		db=DB.getDatabase();
	}
	
	public RideDetails  searchRequstedRides(int id ) {
        for (int i = 0; i < db.getRequestedRides().size(); i++) {
           RideDetails rd = db.getRequestedRides().get(i);
           if(rd.getRideId() == id)
               return rd;
      }
        return null;
   }
}
