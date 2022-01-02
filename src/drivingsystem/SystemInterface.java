package drivingsystem;

import java.util.Scanner;


public class SystemInterface extends Thread{
	
	
	static DB d = DB.getDatabase();
	
	public static void userInterface(AbstractUser U)
	{
		System.out.println("1. Request a Ride ");
		System.out.println("2. Rate a Driver ");
		System.out.println("3. log out");
		Scanner input= new Scanner(System.in);
		int choice=input.nextInt();
		
		switch(choice)
		{
		case 1 :
			System.out.println("Enter Your current location : ");
			System.out.println("Enter Your Destination : ");
			String source=input.nextLine();
			source=input.nextLine();
			String des=input.nextLine();
			((RegularUser)U).getConroler().requestRide(source,des);
			userInterface(U);
			break;
		case 2:
			System.out.println("Enter Your Driver Id & Your Rate : ");
			int driverId=input.nextInt();
			float rate =input.nextFloat();
			((RegularUser)U).getConroler().rate(driverId, rate);
			userInterface( U);
			break;
		case 3:
			U.setLogedIn(false);
			mainInterface();
			break;
		default :
			System.out.println("something went wrong");
			userInterface( U);
		}
		//input.close();
	}
	public static void driverInterface(AbstractUser D) {
		System.out.println("1. Take a Ride ");
		System.out.println("2. Add favoirite place ");
		System.out.println("3. Suggest Offer for a Ride ");
		System.out.println("4. log out");
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
			System.out.println("Enter Ride Id and Price Offer : ");
			int rideId=input.nextInt();
			float price=input.nextInt();
			((Driver)D).controler.suggestPrice(rideId, price);
			driverInterface(D);
			break;
		case 4:
			D.setLogedIn(false);
			mainInterface();
			break;
		default :
			System.out.println("something went wrong");
			driverInterface(D);
		}
		//input.close();
	}
	public static void adminInterface(AbstractUser A) {
            Admin x= (Admin)A;
                 System.out.println("a name ="+x.name);
		System.out.println("1. list Users ");
		System.out.println("2. list Drivers ");
		System.out.println("3. list appending Drivers ");
		System.out.println("4. suspend a User ");
		System.out.println("5. Suspend a Driver ");
		System.out.println("6. log out");
		Scanner input= new Scanner(System.in);
		int choice=input.nextInt();
		
		switch(choice)
		{
		case 1 :
			A.DataBase.listRuser();
			System.out.println("7. Suspend a User ");
			System.out.println("8. Go Back ");
			choice=input.nextInt();
			switch(choice)
			{
			case 7 :
				System.out.println("Enter User Id : ");
				int id=input.nextInt();
				x.controler.suspendRuser(id);
				adminInterface(A);
				break;
			case 8 :
				adminInterface(A);
			break;
			}
		case 2:
			A.DataBase.listDrivers();
			System.out.println("7. Suspend a Driver ");
			System.out.println("8. Go Back ");
			choice=input.nextInt();
			switch(choice)
			{
			case 7 :
				System.out.println("Enter User Id : ");
				int id=input.nextInt();
				((Admin)A).controler.suspendDriver(id);
				adminInterface(A);
				break;
			case 8 :
				adminInterface(A);
				break;
			default :
				System.out.println("Envalid Number");
				adminInterface(A);
			}
			break;
			
			
			
			
		case 3 :
                        System.out.println("X name ="+x.name);
			x.controler.listAllPending();
			System.out.println("7. Reject a Driver ");
			System.out.println("8. Accept a Driver");
			System.out.println("9. Go back");
			choice=input.nextInt();
			switch(choice)
			{
			case 7 :
				System.out.println("Enter User Id : ");
				int id=input.nextInt();
				((Admin)A).controler.RejectPending(id);
				adminInterface(A);
				break;
			case 8 :
				System.out.println("Enter User Id : ");
				id=input.nextInt();
				((Admin)A).controler.verify(id);
				adminInterface(A);
				break;
			case 9 :
				adminInterface(A);
				break;
			default :
				System.out.println("Envalid Number");
				adminInterface(A);
			}
			break;
		case 4 :
			System.out.println("Enter User Id : ");
			int id=input.nextInt();
			((Admin)A).controler.suspendRuser(id);
			adminInterface(A);
			break;
		case 5 :	
			System.out.println("Enter User Id : ");
			id=input.nextInt();
			((Admin)A).controler.suspendDriver(id);
			adminInterface(A);
			break;
		case 6 :	
			A.setLogedIn(false);
			mainInterface();
			break;
		default :
			System.out.println("Envalid Number");
			adminInterface(A);
		}
		//input.close();
	}
	public static void registrationInterface() {
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
			System.out.println("Enter Your Information in the next Order : ");
			System.out.println("Name :  Mobile Number :  Password :  Email : ");
			AbstractUser U=new RegularUser();
			String userInput=input.nextLine();
			
			userInput=input.nextLine();
			U.setName(userInput);
			userInput=input.nextLine();
			U.setMobileNumber(userInput);
			userInput=input.nextLine();
			U.setPassword(userInput);
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
			System.out.println("Enter Your Information in the next Order : ");
			System.out.println("AdminName :  Mobile Number :  Password :  Email : ");
			AbstractUser A=new Admin();
			
			String adminInput=input.nextLine();
			
			System.out.println("name");
			adminInput=input.nextLine();
			A.setName(adminInput);
			
			
			System.out.println("mobile");
			adminInput=input.nextLine();
			A.setMobileNumber(adminInput);
			
			System.out.println("password");
			adminInput=input.nextLine();
			A.setPassword(adminInput);
			
			System.out.println("email");
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
			System.out.println("Envalid Number");
			registrationInterface();
		}
	}
	public static void loginInterface() {
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
			System.out.println("Password : ");
			
			System.out.println("d_m");
			String m=input.nextLine();
			m=input.nextLine();
			System.out.println("d_p");
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
//			for(int i=0; i<d.getAdmins().size(); i++)
//			{
//				System.out.println(d.getAdmins().get(i).getName());
//				System.out.println(d.getAdmins().get(i).getPassword());
//			
//			}
			
			System.out.println("Mobile Number : ");
			System.out.println("Password : ");
			
			String mo=input.nextLine();
			mo=input.nextLine();
			password=input.nextLine();
			
			l=new AdminLogin();
			
			AbstractUser A= l.verifyInformation(mo, password);
			//A =new Admin();
			if(A !=null)
			{
                                System.out.println("a name ="+A.name);
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
			System.out.println("Envalid Number");
			loginInterface();
		}	
		//input.close();
	}
	
	public static void mainInterface() {
		
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
		//input.close();
	}
	
//	@Override
//	public void run() {
//		mainInterface();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {}
//	}
	
	public static void main(String[] args) {
		
		
//		Regesteration R=new AdminRegesteration();
//		System.out.println("Enter Your Information in the next Order : ");
//		System.out.println("AdminName :  Mobile Number :  Password :  Email : ");
//		AbstractUser A=new Admin();
//		
//		Scanner input=new Scanner(System.in);
//		
//		String adminInput=input.nextLine();
//		
//		System.out.println("name");
////		adminInput=input.nextLine();
//		A.setName(adminInput);
//		
//		
//		System.out.println("mobile");
//		adminInput=input.nextLine();
//		A.setMobileNumber(adminInput);
//		
//		System.out.println("password");
//		adminInput=input.nextLine();
//		A.setPassword(adminInput);
//		
//		System.out.println("email");
//		adminInput=input.nextLine();
//		A.setEmail(adminInput);
//		
//		R.regester(A);
//		
//		System.out.println(d.getAdmins().get(0).getName());
//		
//		
//		
//		
//		
//		System.out.println("Mobile Number : ");
//		System.out.println("Password : ");
//		
//		String mo=input.nextLine();
//		
////		mo=input.nextLine();
//		String password=input.nextLine();
//		
//		System.out.print(mo +"   "+password);
//
//		
//		
//		
//		Login l=new AdminLogin();
//		A = l.verifyInformation(mo, password);
//		if(A !=null)
//		{
//			System.out.println("in if condition");
//			//adminInterface(A);
//		}
//		else
//		{
//			System.out.println("User not found");
//			loginInterface();
//		}
//		for(int i=0; i<d.getAdmins().size(); i++)
//		{
//			System.out.println(d.getAdmins().get(i).getName());
//			System.out.println(d.getAdmins().get(i).getPassword());
//		
//		}
		
		
		
		
		
    	mainInterface();
    	

    }

	
}
