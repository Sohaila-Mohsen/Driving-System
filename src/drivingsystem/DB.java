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
    //public AbstractUser searchUser(String monbileNumber, String pass){

  
    //public RegularUser searchUser(int id){


    //search driver
    
    
    //public AbstractUser searchAdminPhone(String phone) {
    
            
    //search pending
    
   // public AbstractUser searchDriver(String phone) {


    //public RideDetails  searchRequstedRides(int id ) {
   
  
    //search regular user
    
    
    //searchRegularUser(AbstractUser regular)
        

    public void addRuser(AbstractUser rUser){
        regularUsers.add((RegularUser) rUser);
    }
    public void addAdmin (Admin admin){
        admins.add(admin);
    }
    public void removePending(Driver driver){
        pending.remove(driver);
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
        System.out.println("done 3");
    } 



    private DB() {
            regularUsers = new ArrayList<>();
            admins = new ArrayList<>();
            drivers =  new ArrayList<>();
            pending =  new ArrayList<>();
            requestedRides =  new ArrayList<>();
        }

    
}
