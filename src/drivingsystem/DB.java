package drivingsystem;

import java.util.ArrayList;


public class DB {
	private ArrayList <Driver> drivers =new ArrayList<>();
    private ArrayList <Driver> pending=new ArrayList<>();
    private ArrayList <RegularUser> regularUsers=new ArrayList<>();
    private ArrayList <Admin> admins=new ArrayList<>();
    private ArrayList <RideDetails> requestedRides=new ArrayList<>();
    private static DB Database;

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Driver> getPending() {
        return pending;
    }

    public void setPending(ArrayList<Driver> pending) {
        this.pending = pending;
    }

    public ArrayList<RegularUser> getRegularUsers() {
        return regularUsers;
    }

    public void setRegularUsers(ArrayList<RegularUser> regularUsers) {
        this.regularUsers = regularUsers;
    }

    public ArrayList <Admin> getAdmins() {
		return admins;
	}

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<RideDetails> getRequestedRides() {
        return requestedRides;
    }

    public void setRequestedRides(ArrayList<RideDetails> requestedRides) {
        this.requestedRides = requestedRides;
    }
    
    public static synchronized DB getDatabase() {
        if(Database == null){
            Database = new DB();
        }
        return Database;
    }
    public AbstractUser searchUser(String monbileNumber, String pass){
        for(int i=0 ; i<regularUsers.size() ; i++)
        {
            if(regularUsers.get(i).mobileNumber.equalsIgnoreCase(monbileNumber) && regularUsers.get(i).password.equalsIgnoreCase(pass)){
                return regularUsers.get(i) ;
            }
        }
        return null;
    }

    public RegularUser searchUser(int id){
        for(int i=0 ; i<regularUsers.size() ; i++)
        {
            if(regularUsers.get(i).id == id){
                return regularUsers.get(i) ;
            }
        }
        return null;
    }
    public Driver  searchDriver(int id ) {
         for (int i = 0; i < drivers.size(); i++) {
            Driver d = drivers.get(i);
            if(d.getId() == id)
            {  return d;}
       }
         return null;
    }
    public AbstractUser searchAdminPhone(String phone) {
    	for (int i = 0; i < getAdmins().size(); i++) {
    		if(phone.contains(getAdmins().get(i).getMobileNumber())) {
    			return getAdmins().get(i);
    		}
    	}
		return null;
    }
        public AbstractUser searchPending(String phone) {
		for (int i = 0; i < pending.size(); i++) {
			if(phone.contains(pending.get(i).mobileNumber)) {
				return pending.get(i);
			}
		}
		return null;
    }
            
    public Driver  searchPennding(int id ) {
         for (int i = 0; i < pending.size(); i++) {
            Driver d = pending.get(i);
            if(d.id == id)
                return d;
       }
         return null;
    }
    
    public AbstractUser searchDriver(String phone) {
    	for (int i = 0; i < drivers.size(); i++) {
    		if(phone.contains(drivers.get(i).getMobileNumber())) {
    			return drivers.get(i);
    		}
    	}

		return null;
    }

    public RideDetails  searchRequstedRides(int id ) {
         for (int i = 0; i < requestedRides.size(); i++) {
            RideDetails rd = requestedRides.get(i);
            if(rd.getRideId() == id)
                return rd;
       }
         return null;
    }
    public AbstractUser searchRegularUser(String phone) {
    	for (int i = 0; i < regularUsers.size(); i++) {
    		if(phone==regularUsers.get(i).mobileNumber) {
    			return regularUsers.get(i);
    		}
    	}
    	return null;
    }
    public boolean searchRegularUser(AbstractUser regular) {
    	for (int i = 0; i < regularUsers.size(); i++) {
    		if(regular.mobileNumber==regularUsers.get(i).mobileNumber) {
    			return true;
    		}
    	}

		return false;
    	}
        

    public void addRuser(AbstractUser rUser){
        regularUsers.add((RegularUser) rUser);
    }
    public void addAdmin (AbstractUser admin){
        ((Admin) admin).getEmail();
        getAdmins().add((Admin) admin);
    }
    public void removePending(Driver driver){
        drivers.remove(driver);
    }

    public void addPending(AbstractUser driver) {
        pending.add((Driver) driver);

    }
    public void  addDriver(AbstractUser driver ) {
        drivers.add((Driver) driver);
    }
    public void listDrivers() {
        for (int i = 0; i < drivers.size(); i++) {
            Driver d = drivers.get(i);
            System.out.println("Driver # "+d.getId()+"\n"+d.getName()+"\nWith avrege Rating "+d.getRating().getAvrege()+" star");    
            System.out.println("------------------------------------------");
        }

    } 
    public void listRuser(){
        for (int i = 0; i < regularUsers.size(); i++) {
            RegularUser r = regularUsers.get(i);
            System.out.println("User # "+r.id+"\n"+r.name); 
            System.out.println("------------------------------------------");
        }
    }
    public void listPendding(){
        for (int i = 0; i < pending.size(); i++) {
            Driver d = pending.get(i);
            System.out.println("Driver # "+d.id+"\n"+d.name);
            System.out.println("------------------------------------------");
        }
    }
    public void listRides(){
        for(int i = 0; i < requestedRides.size(); i++) {
            RideDetails ride= requestedRides.get(i);
            System.out.println("Ride # "+ride.getRideId()+" : with"+"\n"+"Source : "+ride.getSource()+"\n"+"Destination" +ride.getDestnation());
        }
    }
    public void addRide(RideDetails confirmed){
        for(int i = 0; i < requestedRides.size(); i++) {
            if(confirmed.equals(requestedRides.get(i)))
                requestedRides.remove(i);
        }
    }
    public void addRequested(RideDetails requsted ) {
        requestedRides.add(requsted);
         Notification n = new DriverNotification(requsted.getSource() , requsted.getDestnation() ,requsted.getUser().id);
        n.notifyAllObservers();
    } 



    private DB() {
            regularUsers = new ArrayList<>();
            admins = new ArrayList<>();
            drivers =  new ArrayList<>();
            pending =  new ArrayList<>();
            requestedRides =  new ArrayList<>();
        }

    
}
