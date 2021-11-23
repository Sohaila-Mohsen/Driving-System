package drivingsystem;

import java.util.Scanner;

public class SystemInterface {
	public static void userInterface(RegularUser U)
	{
		System.out.println("1. Request a Ride ");
		System.out.println("2. log out");
		Scanner input= new Scanner(System.in);
		int choice=input.nextInt();
		
		switch(choice)
		{
		case 1 :
			System.out.println("Enter Your current location : ");
			System.out.println("Enter Your Destination : ");
			String source=input.nextLine();
			String des=input.nextLine();
			U.requestRide(source,des);
			break;
		case 2:
			mainInterface();
			break;
		default :
			System.out.println("something went wrong");
			userInterface( U);
		}
	}
	public static void driverInterface(Driver D) {
		
	}
	public static void adminInterface(Admin A) {
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
				A.suspendRuser(id);
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
				A.suspendDriver(id);
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
			A.listAllPending();
			System.out.println("7. Reject a Driver ");
			System.out.println("8. Accept a Driver");
			System.out.println("9. Go back");
			choice=input.nextInt();
			switch(choice)
			{
			case 7 :
				System.out.println("Enter User Id : ");
				int id=input.nextInt();
				A.RejectPending(id);
				adminInterface(A);
				break;
			case 8 :
				System.out.println("Enter User Id : ");
				id=input.nextInt();
				A.verify(id);
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
			A.suspendRuser(id);
			adminInterface(A);
			break;
		case 5 :	
			System.out.println("Enter User Id : ");
			id=input.nextInt();
			A.suspendDriver(id);
			adminInterface(A);
			break;
		case 6 :	
			mainInterface();
			break;
		default :
			System.out.println("Envalid Number");
			adminInterface(A);
		}
	}
	public static void registrationInterface() {
		
	}
	public static void loginInterface() {
		Scanner input=new Scanner(System.in);
		System.out.println("Mobile Number : ");
		System.out.println("Password : ");
		String mobile=input.nextLine();
		String password=input.nextLine();
		if(AbstractUser.login(mobile ,password))
		{
			
		}
		else
		{
			System.out.println("User not found");
			loginInterface();
		}
			
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
		
	}
	
	
	public static void main(String args[]) {
		
	}

}
