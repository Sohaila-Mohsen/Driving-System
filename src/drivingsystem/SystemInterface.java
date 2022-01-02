package drivingsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService
public class SystemInterface extends Thread{
	
	
	static DB d = DB.getDatabase();
	
	public static void userInterface(AbstractUser U)
	{
            try {
                System.out.println("1. Request a Ride ");
                System.out.println("2. Accept an Offer ");
                System.out.println("3. Rate a Driver ");
                System.out.println("4. Show Notification ");
                System.out.println("5. log out");
                Scanner input= new Scanner(System.in);
                int choice=input.nextInt();
                
                switch(choice)
                {
                    case 1 :
                        System.out.print("Enter Your current location : ");
                        String source=input.nextLine();
                        source=input.nextLine();
                        System.out.println("Enter Your Destination : ");
                        String des=input.nextLine();
                        System.out.println("Enter Number Of Passenger : ");
                        int numOfPassenger = input.nextInt();
                        ((RegularUser)U).getConroler().requestRide(source,des,numOfPassenger);
                        userInterface(U);
                        break;
                    case 2:
                        ((RegularUser)U).getCurrentRide().listSuggested();
                        System.out.print("Enter Driver Id : ");
                        int ID = input.nextInt();
                        if(((RegularUser)U).getConroler().acceptOffer(ID))
                            System.out.println("Have Nice Ride \u2764");
                        else
                            System.out.println("Something went wrong");
                        userInterface( U);
                        break;
                    case 3:
                        System.out.println("Enter Your Driver Id & Your Rate : ");
                        int driverId=input.nextInt();
                        float rate =input.nextFloat();
                        ((RegularUser)U).getConroler().rate(driverId, rate);
                        userInterface( U);
                        break;
                    case 4:
                        ((RegularUser)U).getConroler().showNotification();
                        userInterface( U);
                        break;
                    case 5:
                        U.setLogedIn(false);
                        mainInterface();
                        break;
                    default :
                        System.out.println("something went wrong");
                        userInterface( U);
                }
                //input.close();
            } catch (ParseException ex) {
                Logger.getLogger(SystemInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	public static void driverInterface(AbstractUser D) {
            try {
                System.out.println("1. Take a Ride ");
                System.out.println("2. Add favoirite place ");
                System.out.println("3. Check Balence ");
                System.out.println("4. Start Ride ");
                System.out.println("5. End Ride ");
                System.out.println("6. Show Notifications ");
                System.out.println("7. log out");
                Scanner input= new Scanner(System.in);
                int choice=input.nextInt();
                
                switch(choice)
                {
                    case 1 :
                        ((Driver)D).controler.listPossibleRides();
                        System.out.println("1. Suggest Price : ");
                        System.out.println("2. back : ");
                        choice=input.nextInt();
                        switch(choice)
                        {
                            case 1 :
                                System.out.println("Enter Ride Id and Price Offer : ");
                                int rideId=input.nextInt();
                                float price=input.nextInt();
                                ((Driver)D).controler.suggestPrice(rideId, price);
                                driverInterface(D);
                                break;
                            case 2 :
                                driverInterface(D);
                                break;
                            default:
                                driverInterface(D);
                        }
                        
                        break;
                    case 2:
                        System.out.println("Enter your Favorite Area");
                        String place=input.nextLine();
                        place=input.nextLine();
                        ((Driver)D).addFavoriteArea(place);
                        driverInterface(D);
                        break;
                    case 3:
                        ((Driver)D).controler.showBalene();
                        driverInterface(D);
                        break;
                    case 4:
                        ((Driver)D).controler.startRide();
                        //System.out.println("Have Nice Ride \u2764");
                        driverInterface(D);
                        break;
                    case 5:
                        ((Driver)D).controler.endRide();
                        ((Driver)D).controler.showBalene();
                        driverInterface(D);
                        break;
                    case 6:
                        ((Driver)D).controler.showNotification();
                        driverInterface(D);
                        break;
                    case 7:
                        D.setLogedIn(false);
                        mainInterface();
                        break;
                    default :
                        System.out.println("something went wrong");
                        driverInterface(D);
                }
                //input.close();
            } catch (ParseException ex) {
                Logger.getLogger(SystemInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	public static void adminInterface(AbstractUser A) {
            try {
                Admin x= (Admin)A;
                System.out.println("1. list Users ");
                System.out.println("2. list Drivers ");
                System.out.println("3. list appending Drivers ");
                System.out.println("4. list Events ");
                System.out.println("5. suspend a User ");
                System.out.println("6. Suspend a Driver ");
                System.out.println("7. Add Discount Area ");
                System.out.println("8. log out");
                System.out.println();
                Scanner input= new Scanner(System.in);
                int choice=input.nextInt();
                
                switch(choice)
                {
                    case 1 :
                        A.DataBase.listRuser();
                        System.out.println("1. Suspend a User ");
                        System.out.println("2. Go Back ");
                        choice=input.nextInt();
                        switch(choice)
                        {
                            case 1 :
                                System.out.println("Enter User Id : ");
                                int id=input.nextInt();
                                x.controler.suspendRuser(id);
                                adminInterface(A);
                                break;
                            case 2 :
                                adminInterface(A);
                                break;
                        }
                    case 2:
                        A.DataBase.listDrivers();
                        System.out.println("1. Suspend a Driver ");
                        System.out.println("2. Go Back ");
                        choice=input.nextInt();
                        switch(choice)
                        {
                            case 1 :
                                System.out.println("Enter User Id : ");
                                int id=input.nextInt();
                                ((Admin)A).controler.suspendDriver(id);
                                adminInterface(A);
                                break;
                            case 2 :
                                adminInterface(A);
                                break;
                            default :
                                System.out.println("Envalid Number");
                                adminInterface(A);
                        }
                        break;
                        
                        
                        
                        
                    case 3 :
                        x.controler.listAllPending();
                        System.out.println("1. Reject a Driver ");
                        System.out.println("2. Accept a Driver");
                        System.out.println("3. Go back");
                        choice=input.nextInt();
                        switch(choice)
                        {
                            case 1 :
                                System.out.println("Enter User Id : ");
                                int id=input.nextInt();
                                ((Admin)A).controler.RejectPending(id);
                                adminInterface(A);
                                break;
                            case 2 :
                                System.out.print("Enter User Id : ");
                                id=input.nextInt();
                                ((Admin)A).controler.verify(id);
                                adminInterface(A);
                                break;
                            case 3 :
                                adminInterface(A);
                                break;
                            default :
                                System.out.println("Invalid Number");
                                adminInterface(A);
                        }
                        break;
                    case 4 :
                        x.controler.listAllEvents();
                        adminInterface(A);
                        break;
                    case 5 :
                        System.out.print("Enter User Id : ");
                        int id=input.nextInt();
                        ((Admin)A).controler.suspendRuser(id);
                        adminInterface(A);
                        break;
                    case 6 :
                        System.out.print("Enter User Id : ");
                        id=input.nextInt();
                        ((Admin)A).controler.suspendDriver(id);
                        adminInterface(A);
                        break;
                    case 7 :
                        System.out.print("Enter Area Name : ");
                        String area = input.nextLine();
                        area = input.nextLine();
                        ((Admin)A).controler.addDiscountArea(area);
                        adminInterface(A);
                        break;
                    case 8 :
                        A.setLogedIn(false);
                        mainInterface();
                        break;
                    default :
                        System.out.println("Invalid Number");
                        adminInterface(A);
                }
                //input.close();
            } catch (ParseException ex) {
                Logger.getLogger(SystemInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	public static void registrationInterface() throws ParseException {
		System.out.println("1. Register as a User ");
		System.out.println("2. Register as a Driver ");
		System.out.println("3. Register as an Admin ");
		System.out.println("4. Go Back ");
		
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		
		Regesteration R;
		switch(choice)
		{
		case 1 :
			R=new RedularUserRegestration();
			System.out.println("Name : ");
			AbstractUser U=new RegularUser();
			String userInput=input.nextLine();
			
			userInput=input.nextLine();
			U.setName(userInput);
                        System.out.println("Mobile Number : ");
			userInput=input.nextLine();
			U.setMobileNumber(userInput);
                        System.out.println("Enter Birth Date ");
                        System.out.println("Day : ");
                        int day = input.nextInt();
                        System.out.println("Month : ");
                        int month = input.nextInt();
                        System.out.println("Year : ");
                        int year = input.nextInt();
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        String Date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
                        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(Date);
                        U.setBirthDate(date);
                        System.out.println("Password : ");
                        userInput=input.nextLine();
			userInput=input.nextLine();
			U.setPassword(userInput);
                        System.out.println("Email : ");
			userInput=input.nextLine();
			U.setEmail(userInput);
			
			R.regester(U);

			mainInterface();
			break;
		case 2 :
			R=new DriverRegesteration();
			System.out.println("Enter Your Information in the next Order : ");
			System.out.println("Name :  Mobile Number :  Password :  Email :  Licence :  NationalID : ");
			AbstractUser D=new Driver();
			
			String driverInput=input.nextLine();
			
			driverInput=input.nextLine();
			D.setName(driverInput);
			driverInput=input.nextLine();
			D.setMobileNumber(driverInput);
			driverInput=input.nextLine();
			D.setPassword(driverInput);
			driverInput=input.nextLine();
			D.setEmail(driverInput);
			driverInput=input.nextLine();
			((Driver)D).setLicence(driverInput);
			driverInput=input.nextLine();
			((Driver)D).setNationalId(driverInput);
			
			R.regester(D);
			mainInterface();
			break;
		case 3 :
			R=new AdminRegesteration();
			AbstractUser A=new Admin();
			
			String adminInput=input.nextLine();
			
			System.out.println("Name : ");
			adminInput=input.nextLine();
			A.setName(adminInput);
			
			
			System.out.println("Mobile : ");
			adminInput=input.nextLine();
			A.setMobileNumber(adminInput);
			
			System.out.println("Password : ");
			adminInput=input.nextLine();
			A.setPassword(adminInput);
			
			System.out.println("Email : ");
			adminInput=input.nextLine();
			A.setEmail(adminInput);
			
			R.regester(A);
			System.out.println(d.getAdmins().get(0).getName());
			mainInterface();
			break;
		case 4 :
			mainInterface();
			break;
		default :
			System.out.println("Invalid Number");
			registrationInterface();
		}
	}
	public static void loginInterface() {
            try {
                Scanner input=new Scanner(System.in);
                
                System.out.println("1. Login as a User ");
                System.out.println("2. Login as a Driver ");
                System.out.println("3. Login as an Admin ");
                System.out.println("4. Go Back ");
                
                int choice=input.nextInt();
                
                Login l;
                switch(choice)
                {
                    case 1 :
                        
                        System.out.println("Mobile Number : ");
                        System.out.println("Password : ");
                        
                        ///strange Error///
                        String mobile=input.nextLine();
                        mobile=input.nextLine();
                        
                        String password=input.nextLine();
                        
                        l=new RegularUserLogin();
                        AbstractUser U= l.verifyInformation(mobile, password);
                        if(U !=null)
                        {
                            
                            userInterface(U);
                        }
                        else
                        {
                            System.out.println("User not found");
                            loginInterface();
                        }
                        break;
                    case 2 :
                        System.out.println("Mobile Number : ");
                        String m=input.nextLine();
                        m=input.nextLine();
                        System.out.println("Password : ");
                        String p =input.nextLine();
                        
                        l=new DriverLogin();
                        AbstractUser D=l.verifyInformation(m, p);
                        if(D !=null)
                        {
                            driverInterface(D);
                        }
                        else
                        {
                            System.out.println("User not found");
                            loginInterface();
                        }
                        break;
                    case 3 :                       
                        System.out.println("Mobile Number : ");
                        
                        
                        String mo=input.nextLine();
                        mo=input.nextLine();
                        System.out.println("Password : ");
                        password=input.nextLine();
                        
                        l=new AdminLogin();
                        
                        AbstractUser A= l.verifyInformation(mo, password);
                        if(A !=null)
                        {
                            adminInterface(A);
                        }
                        else
                        {
                            System.out.println("User not found");
                            loginInterface();
                        }
                        break;
                    case 4 :
                        mainInterface();
                        break;
                    default:
                        System.out.println("Invalid Number");
                        loginInterface();
                }
                //input.close();
            } catch (ParseException ex) {
                Logger.getLogger(SystemInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	public static void mainInterface() throws ParseException {
		
		System.out.println("choose: ");
		System.out.println("1. log in");
		System.out.println("2. create Account");
		System.out.println("3. exit");
		
		Scanner input= new Scanner(System.in);
		int choice=input.nextInt();
		
		switch(choice)
		{
		case 1:
			loginInterface();
			break;
		case 2:
			registrationInterface();
			break;
		case 3:
			System.exit(0);
		default :
			System.out.println("Enter A Valid Number");
			mainInterface();
		}
	}
		
    public static void main(String[] args) throws ParseException {		
    	mainInterface();
    	

    }

	
}
