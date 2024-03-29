package com.example.SW2_Project.drivingsystem.src.drivingsystem;
import java.util.ArrayList;

public class DB {
    private ArrayList <Driver> drivers =new ArrayList<>();
    private ArrayList <Driver> pending=new ArrayList<>();
    private ArrayList <RegularUser> regularUsers=new ArrayList<>();
    private ArrayList <Admin> admins=new ArrayList<>();
    private ArrayList <RideDetails> requestedRides=new ArrayList<>();
    private ArrayList <String> discountAreas=new ArrayList<>();
     private ArrayList <Event> events = new ArrayList<>();
    private ArrayList<Driver> regularUser;
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

    public ArrayList<String> getDiscountAreas() {
        return discountAreas;
    }

    public void setDiscountAreas(ArrayList<String> discountAreas) {
        this.discountAreas = discountAreas;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
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
    public void addEvent(Event event) {
        events.add(event);

    }
    public void addArea(String area) {
        discountAreas.add(area);

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
         System.out.println("------------------------------------------");
    }
    public void listEvents(){
        for(int i = 0; i < events.size(); i++) {
            System.out.println("i = "+i);
            switch(events.get(i).getEventName()){
                case PriceSuggested:
                    System.out.println("Driver : "+events.get(i).getCaptain().getName()+" suggested "+events.get(i).getPrice()+" $ to Ride # "+events.get(i).getRide().getRideId()+" at "+events.get(i).getEventTime().toString()+"\n");
                    break;
                case OfferAccepted:
                    System.out.println("User : "+events.get(i).getUser().getName()+" Accepted Driver # "+events.get(i).getCaptain().getId()+" Offer at "+events.get(i).getEventTime().toString()+"\n");
                    break;
                case DriverArived:
                    System.out.println("Driver : "+events.get(i).getCaptain().getName()+" Arrived  to User : "+events.get(i).getUser().getName()+" Source at "+events.get(i).getEventTime().toString()+"\n");
                    break;
                case RideEnded:
                    System.out.println("Driver : "+events.get(i).getCaptain().getName()+" Arrived  to User : "+events.get(i).getUser().getName()+" Destination at "+events.get(i).getEventTime().toString()+"\n");
                    break;
            }
            
        }
         System.out.println("------------------------------------------");
    }
    public void addRide(RideDetails confirmed){
        for(int i = 0; i < requestedRides.size(); i++) {
            if(confirmed.equals(requestedRides.get(i)))
                requestedRides.remove(i);
        }
    }
    public void addRequested(RideDetails requsted) {
        requestedRides.add(requsted);
        Notification n = new DriverNotification(requsted.getSource() , requsted.getDestnation() ,requsted.getUser().id , requsted.getNumOfPassengers());
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

    public ArrayList<String> ListAllPendding() {
        ArrayList Arr = new ArrayList<>();
        String s;
        for (int i = 0; i < pending.size(); i++) {
            Driver d = pending.get(i);
            s="Driver # "+d.id+"\n"+d.name;
            Arr.add(s);
        }
        return Arr;
    }

    public ArrayList<String> ListRuser() {
        ArrayList Arr = new ArrayList<>();
        String s;
        for (int i = 0; i < regularUsers.size(); i++) {
            RegularUser r = regularUsers.get(i);
            s ="User # "+r.id+"\n"+r.name; 
            Arr.add(s);
        }
        return Arr;
    }

    public ArrayList<String> ListEvents() {
        ArrayList Arr = new ArrayList<>();
        String s="";
        for(int i = 0; i < events.size(); i++) {
            System.out.println("i = "+i);
            switch(events.get(i).getEventName()){
                case PriceSuggested:
                    s="Driver : "+events.get(i).getCaptain().getName()+" suggested "+events.get(i).getPrice()+" $ to Ride # "+events.get(i).getRide().getRideId()+" at "+events.get(i).getEventTime().toString()+"\n";
                    break;
                case OfferAccepted:
                    s="User : "+events.get(i).getUser().getName()+" Accepted Driver # "+events.get(i).getCaptain().getId()+" Offer at "+events.get(i).getEventTime().toString()+"\n";
                    break;
                case DriverArived:
                    s="Driver : "+events.get(i).getCaptain().getName()+" Arrived  to User : "+events.get(i).getUser().getName()+" Source at "+events.get(i).getEventTime().toString()+"\n";
                    break;
                case RideEnded:
                    s="Driver : "+events.get(i).getCaptain().getName()+" Arrived  to User : "+events.get(i).getUser().getName()+" Destination at "+events.get(i).getEventTime().toString()+"\n";
                    break;
            }
            Arr.add(s);
        }
        return Arr;
    }
    
}
